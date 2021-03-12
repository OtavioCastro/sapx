package br.com.erp.sapx.usecase.clients.impl;

import br.com.erp.sapx.domain.Client;
import br.com.erp.sapx.domain.UpdateClientRequest;
import br.com.erp.sapx.gateway.ClientGateway;
import br.com.erp.sapx.usecase.clients.UpdateClientUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import static java.util.Objects.isNull;
import static java.util.Optional.ofNullable;
import static org.springframework.util.StringUtils.isEmpty;

@Service
@AllArgsConstructor
public class UpdateClientUseCaseImpl implements UpdateClientUseCase {

    private final ClientGateway gateway;

    @Override
    public Client execute(Integer numCliente, UpdateClientRequest request) {
        final var client = ofNullable(gateway.findClientByNum(numCliente))
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Cliente número " + numCliente +" não encontrado."));

        final var clientUpdate = client.toBuilder()
                .nome(isEmpty(request.getNome()) ? client.getNome() : request.getNome())
                .cnpj(isEmpty(request.getCnpj()) ? client.getCnpj() : request.getCnpj())
                .build();

        return ofNullable(gateway.addOrUpdateCliente(clientUpdate))
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.UNPROCESSABLE_ENTITY, "Não foi possível atualizar o cliente."));
    }
}
