package br.com.erp.sapx.gateway;

import br.com.erp.sapx.domain.Client;

import java.util.List;

public interface ClientGateway {
    List<Client> findAllClientes();
    Client findClienteById(String id);
    Client findClientByNum(Integer numCliente);
    Client addOrUpdateCliente(Client client);
    void removeCliente(Integer id);
}
