package br.com.erp.sapx.repository;

import br.com.erp.sapx.domain.Client;
import br.com.erp.sapx.repository.model.ClientModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<ClientModel, String> {
    Client findByNumCliente(Integer numCliente);
}
