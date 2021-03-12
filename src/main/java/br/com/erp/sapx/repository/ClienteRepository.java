package br.com.erp.sapx.repository;

import br.com.erp.sapx.repository.model.ClientModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ClienteRepository extends MongoRepository<ClientModel, String> {
    Optional<ClientModel> findByNumCliente(Integer numCliente);
}
