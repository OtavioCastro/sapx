package br.com.erp.sapx.usecase.projects.impl;

import br.com.erp.sapx.gateway.ProjectGateway;
import br.com.erp.sapx.usecase.projects.DeleteProjectUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import static java.util.Optional.of;

@Service
@AllArgsConstructor
public class DeleteProjectUseCaseImpl implements DeleteProjectUseCase {

    private final ProjectGateway gateway;

    @Override
    public void execute(Long numProjeto) {
        final var project = of(gateway.findProjectByNumProjeto(numProjeto))
                .filter(projectResponse -> !projectResponse.getId().isBlank())
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Projeto n°" + numProjeto + " não encontrado."));

        gateway.deleteProject(project.getId());
    }
}
