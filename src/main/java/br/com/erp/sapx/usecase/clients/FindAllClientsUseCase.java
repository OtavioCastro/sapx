package br.com.erp.sapx.usecase.clients;

import br.com.erp.sapx.domain.Cliente;

import java.util.List;

public interface FindAllClientsUseCase {
    List<Cliente> execute();
}
