package br.com.erp.sapx.usecase.clients.impl;

import br.com.erp.sapx.domain.Client;
import br.com.erp.sapx.domain.InsertClientRequest;
import br.com.erp.sapx.gateway.ClientGateway;
import br.com.erp.sapx.usecase.clients.InsertClientUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import static java.util.Optional.of;

@Service
@AllArgsConstructor
public class InsertClientUseCaseImpl implements InsertClientUseCase {

    private final ClientGateway clientGateway;

    @Override
    public Client execute(InsertClientRequest request) {
        final var client = Client.builder()
                .numCliente(request.getNumCliente())
                .nome(request.getNome())
                .cnpj(request.getCnpj())
                .build();

        return of(clientGateway.addOrUpdateCliente(client))
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.UNPROCESSABLE_ENTITY, "Não foi possível cadastrar o cliente."));
    }
}
