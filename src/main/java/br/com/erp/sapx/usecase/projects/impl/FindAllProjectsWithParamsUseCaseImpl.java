package br.com.erp.sapx.usecase.projects.impl;

import br.com.erp.sapx.domain.Project;
import br.com.erp.sapx.gateway.ProjectGateway;
import br.com.erp.sapx.usecase.projects.FindAllProjectsWithParamsUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FindAllProjectsWithParamsUseCaseImpl implements FindAllProjectsWithParamsUseCase {

    private final ProjectGateway projectGateway;

    @Override
    public List<Project> execute(Long numProjeto, String nomeCliente, String status) {
        return Optional.of(projectGateway.findAllProjectsWithParams(numProjeto, nomeCliente, status))
                .filter(projects -> !projects.isEmpty())
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Não foram encontrados projetos."));
    }
}
