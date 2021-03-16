package br.com.erp.sapx.usecase.projects.impl;

import br.com.erp.sapx.domain.Project;
import br.com.erp.sapx.domain.UpdateProjectRequest;
import br.com.erp.sapx.gateway.ProjectGateway;
import br.com.erp.sapx.usecase.projects.UpdateProjectUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException;

import static java.util.Optional.ofNullable;
import static org.springframework.util.ObjectUtils.isEmpty;

@Service
@AllArgsConstructor
public class UpdateProjectUseCaseImpl implements UpdateProjectUseCase {

    private final ProjectGateway gateway;

    @Override
    public Project execute(Long numProjeto, UpdateProjectRequest request) {
        final var project = ofNullable(gateway.findProjectByNumProjeto(numProjeto))
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Projeto n°" + numProjeto + " não encontrado."));

        final var projectUpdate = project.toBuilder()
                .dataInicio(isEmpty(request.getDataInicio()) ? project.getDataInicio() : request.getDataInicio())
                .dataFim(isEmpty(request.getDataFim()) ? project.getDataFim() : request.getDataFim())
                .status(isEmpty(request.getStatus()) ? project.getStatus() : request.getStatus())
                .valor(isEmpty(request.getValor()) ? project.getValor() : request.getValor())
                .horasProjeto(isEmpty(request.getHorasProjeto()) ? project.getHorasProjeto() : request.getHorasProjeto())
                .build();

        return ofNullable(gateway.insertOrUpdateProject(projectUpdate))
                .orElseThrow(() ->  new HttpClientErrorException(HttpStatus.UNPROCESSABLE_ENTITY, "Não foi possível atualizar o projeto."));
    }
}
