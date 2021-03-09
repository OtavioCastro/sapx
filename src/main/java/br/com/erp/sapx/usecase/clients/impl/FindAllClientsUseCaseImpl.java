package br.com.erp.sapx.usecase.clients.impl;

import br.com.erp.sapx.domain.Cliente;
import br.com.erp.sapx.gateway.ClienteGateway;
import br.com.erp.sapx.usecase.clients.FindAllClientsUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

import static java.util.Optional.of;

@Service
@AllArgsConstructor
public class FindAllClientsUseCaseImpl implements FindAllClientsUseCase {

    private final ClienteGateway gateway;

    @Override
    public List<Cliente> execute() {
        return of(gateway.findAllClientes())
                .filter(clients -> !clients.isEmpty())
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Não há clientes cadastrados"));
    }
}
