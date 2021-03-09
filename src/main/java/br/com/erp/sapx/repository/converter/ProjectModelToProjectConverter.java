package br.com.erp.sapx.repository.converter;

import br.com.erp.sapx.domain.Project;
import br.com.erp.sapx.repository.model.ProjectModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProjectModelToProjectConverter {

    private final ModelMapper modelMapper;

    public Project convert(ProjectModel projectRepository){ return modelMapper.map(projectRepository, Project.class); }
}
