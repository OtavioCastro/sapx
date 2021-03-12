package br.com.erp.sapx.repository.converter;

import br.com.erp.sapx.domain.Project;
import br.com.erp.sapx.repository.model.ProjectModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProjectToProjectModelConverter {

    private final ModelMapper modelMapper;

    public ProjectModel convert(Project project){
        return modelMapper.map(project, ProjectModel.class);
    }
}
