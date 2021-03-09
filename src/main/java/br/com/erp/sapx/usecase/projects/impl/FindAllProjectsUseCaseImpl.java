package br.com.erp.sapx.usecase.projects.impl;

import br.com.erp.sapx.domain.Project;
import br.com.erp.sapx.gateway.ProjectGateway;
import br.com.erp.sapx.usecase.projects.FindAllProjectsUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

import static java.util.Optional.of;

@Service
@AllArgsConstructor
public class FindAllProjectsUseCaseImpl implements FindAllProjectsUseCase {

    private final ProjectGateway gateway;

    @Override
    public List<Project> execute() {
        return of(gateway.findAllProjects())
                .filter(projetos -> !projetos.isEmpty())
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Não há projetos cadastrados"));
    }
}
