package br.com.erp.sapx.usecase.projects;

import br.com.erp.sapx.domain.InsertProjectRequest;
import br.com.erp.sapx.domain.Project;

public interface InsertProjectUseCase {
    Project execute(InsertProjectRequest request);
}
