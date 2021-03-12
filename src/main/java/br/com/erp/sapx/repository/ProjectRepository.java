package br.com.erp.sapx.repository;

import br.com.erp.sapx.repository.model.ProjectModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends MongoRepository<ProjectModel, String> {
    Optional<ProjectModel> findByNumProjeto(Integer numProjeto);
    List<ProjectModel> findAllByClienteId(String id);
}
