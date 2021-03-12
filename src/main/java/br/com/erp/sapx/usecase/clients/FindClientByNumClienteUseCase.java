package br.com.erp.sapx.usecase.clients;

import br.com.erp.sapx.domain.Client;

public interface FindClientByNumClienteUseCase {
    Client execute(Integer numCliente);
}
