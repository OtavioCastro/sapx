package br.com.erp.sapx.gateway;

import br.com.erp.sapx.domain.Project;

import java.util.List;

public interface ProjectGateway {
    List<Project> findAllProjects();
    List<Project> findAllProjectsByIdCliente(String id);
    Project findProjectById(String id);
    Project findProjectByNumProjeto(Integer numProjeto);
    Project insertOrUpdateProject(Project request);
    void deleteProject(String id);
}
