package br.com.erp.sapx.repository.impl;

import br.com.erp.sapx.domain.Project;
import br.com.erp.sapx.gateway.ProjectGateway;
import br.com.erp.sapx.repository.ProjectRepository;
import br.com.erp.sapx.repository.converter.ProjectModelToProjectConverter;
import br.com.erp.sapx.repository.converter.ProjectToProjectModelConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

@Component
@AllArgsConstructor
public class ProjectGatewayImpl implements ProjectGateway {

    private final ProjectRepository repository;
    private final ProjectModelToProjectConverter toProjectConverter;
    private final ProjectToProjectModelConverter toProjectModelConverter;

    @Override
    public List<Project> findAllProjects() {
        return repository.findAll()
                .stream()
                .map(toProjectConverter::convert)
                .collect(toList());
    }

    @Override
    public Project findProject(String id) {
        // TODO: 09/03/2021
        return null;
    }

    @Override
    public Project insertOrUpdateProject(Project project) {
        return of(project)
                .map(toProjectModelConverter::convert)
                .map(repository::save)
                .map(toProjectConverter::convert)
                .orElseGet(Project::new);
    }
}
