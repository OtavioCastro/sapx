package br.com.erp.sapx.usecase.clients;

import br.com.erp.sapx.domain.Client;

import java.util.List;

public interface FindAllClientsUseCase {
    List<Client> execute();
}
