package br.com.erp.sapx.repository.custom;

import br.com.erp.sapx.repository.model.ProjectModel;

import java.util.List;

public interface ProjectCustomRepository {
    List<ProjectModel> findProjectsWithParams(Long numProj, String nomeCliente, String status);
}
