package br.com.erp.sapx.repository.impl;

import br.com.erp.sapx.domain.Cliente;
import br.com.erp.sapx.gateway.ClienteGateway;
import br.com.erp.sapx.repository.ClienteRepository;
import br.com.erp.sapx.repository.converter.ClienteModelToClienteConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@AllArgsConstructor
public class ClientGatewayImpl implements ClienteGateway {

    private final ClienteRepository clienteRepository;
    private final ClienteModelToClienteConverter toClienteConverter;

    @Override
    public List<Cliente> findAllClientes() {
        return clienteRepository.findAll()
                .stream()
                .map(toClienteConverter::convert)
                .collect(toList());
    }

    @Override
    public Cliente findClienteById(Integer id) {
        return null;
    }

    @Override
    public void addOrUpdateCliente(Cliente cliente) {

    }

    @Override
    public void removeCliente(Integer id) {

    }
}
