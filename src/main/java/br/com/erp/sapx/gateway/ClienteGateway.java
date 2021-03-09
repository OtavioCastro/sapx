package br.com.erp.sapx.gateway;

import br.com.erp.sapx.domain.Cliente;

import java.util.List;

public interface ClienteGateway {
    List<Cliente> findAllClientes();
    Cliente findClienteById(Integer id);
    void addOrUpdateCliente(Cliente cliente);
    void removeCliente(Integer id);
}
