package br.com.erp.sapx.usecase.projects;

import br.com.erp.sapx.domain.Project;

import java.util.List;

public interface FindAllProjectsWithParamsUseCase {
    List<Project> execute(Long numProjeto, String nomeCliente, String status);
}
