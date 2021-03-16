package br.com.erp.sapx.repository;

import br.com.erp.sapx.repository.custom.ProjectCustomRepository;
import br.com.erp.sapx.repository.model.ProjectModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends MongoRepository<ProjectModel, String>, ProjectCustomRepository {
    Optional<ProjectModel> findByNumProjeto(Long numProjeto);
    List<ProjectModel> findAllByClienteId(String id);
}
