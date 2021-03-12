package br.com.erp.sapx.usecase.clients.impl;

import br.com.erp.sapx.domain.Client;
import br.com.erp.sapx.gateway.ClientGateway;
import br.com.erp.sapx.usecase.clients.FindClientByNumClienteUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import static java.util.Optional.ofNullable;

@Service
@AllArgsConstructor
public class FindClientByNumClienteUseCaseImpl implements FindClientByNumClienteUseCase {

    private final ClientGateway clientGateway;

    @Override
    public Client execute(Integer numCliente) {
        return ofNullable(clientGateway.findClientByNum(numCliente))
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));
    }

}
