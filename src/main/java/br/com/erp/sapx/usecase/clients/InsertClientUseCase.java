package br.com.erp.sapx.usecase.clients;

import br.com.erp.sapx.domain.InsertClientRequest;
import br.com.erp.sapx.domain.Client;

public interface InsertClientUseCase {
    Client execute(InsertClientRequest request);
}
