package br.com.erp.sapx.usecase.projects;

import br.com.erp.sapx.domain.Project;
import br.com.erp.sapx.domain.UpdateProjectRequest;

public interface UpdateProjectUseCase {
    Project execute(Integer numProjeto, UpdateProjectRequest request);
}
