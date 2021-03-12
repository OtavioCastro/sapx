package br.com.erp.sapx.repository.impl;

import br.com.erp.sapx.domain.Client;
import br.com.erp.sapx.gateway.ClientGateway;
import br.com.erp.sapx.repository.ClienteRepository;
import br.com.erp.sapx.repository.converter.ClientModelToClientConverter;
import br.com.erp.sapx.repository.converter.ClientToClientModelConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

@Component
@AllArgsConstructor
public class ClientGatewayImpl implements ClientGateway {

    private final ClienteRepository repository;
    private final ClientModelToClientConverter toClientConverter;
    private final ClientToClientModelConverter toClientModelConverter;

    @Override
    public List<Client> findAllClientes() {
        return repository.findAll()
                .stream()
                .map(toClientConverter::convert)
                .collect(toList());
    }

    @Override
    public Client findClientByNum(Integer numCliente) {
        return repository.findByNumCliente(numCliente)
                .map(toClientConverter::convert)
                .orElse(null);
    }

    @Override
    public Client findClienteById(String id) {
        return repository.findById(id)
                .map(toClientConverter::convert)
                .orElse(null);
    }

    @Override
    public Client addOrUpdateCliente(Client client) {
        return of(client)
                .map(toClientModelConverter::convert)
                .map(repository::save)
                .map(toClientConverter::convert)
                .orElse(null);
    }

    @Override
    public void deleteClient(String id) {
        repository.deleteById(id);
    }
}
