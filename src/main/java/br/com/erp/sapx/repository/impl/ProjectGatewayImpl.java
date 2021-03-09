package br.com.erp.sapx.repository.impl;

import br.com.erp.sapx.domain.Project;
import br.com.erp.sapx.gateway.ProjectGateway;
import br.com.erp.sapx.repository.ProjectRepository;
import br.com.erp.sapx.repository.converter.ProjectModelToProjectConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@AllArgsConstructor
public class ProjectGatewayImpl implements ProjectGateway {

    private final ProjectRepository repository;
    private final ProjectModelToProjectConverter toProjectConverter;

    @Override
    public List<Project> findAllProjects() {
        return repository.findAll()
                .stream()
                .map(toProjectConverter::convert)
                .collect(toList());
    }

    @Override
    public Project findProject(Integer id) {
        // TODO: 09/03/2021
        return null;
    }
}
