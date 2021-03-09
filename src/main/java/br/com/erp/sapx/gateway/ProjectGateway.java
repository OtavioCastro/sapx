package br.com.erp.sapx.gateway;

import br.com.erp.sapx.domain.Project;

import java.util.List;

public interface ProjectGateway {
    List<Project> findAllProjects();
    Project findProject(Integer id);
}
