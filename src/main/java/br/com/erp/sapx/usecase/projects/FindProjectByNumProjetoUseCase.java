package br.com.erp.sapx.usecase.projects;

import br.com.erp.sapx.domain.Project;

public interface FindProjectByNumProjetoUseCase {
    Project execute(Integer numProj);
}
