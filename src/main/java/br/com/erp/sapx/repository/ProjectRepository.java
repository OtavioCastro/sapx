package br.com.erp.sapx.repository;

import br.com.erp.sapx.repository.model.ProjectModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectRepository extends MongoRepository<ProjectModel, String> {
}
