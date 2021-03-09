package br.com.erp.sapx.usecase.projects;

import br.com.erp.sapx.domain.Project;

import java.util.List;

public interface FindAllProjectsUseCase {
    List<Project> execute();
}
