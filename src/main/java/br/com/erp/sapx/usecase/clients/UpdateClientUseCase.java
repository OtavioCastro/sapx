package br.com.erp.sapx.usecase.clients;

import br.com.erp.sapx.domain.Client;
import br.com.erp.sapx.domain.UpdateClientRequest;

public interface UpdateClientUseCase {
    Client execute(Integer numCliente, UpdateClientRequest request);
}
