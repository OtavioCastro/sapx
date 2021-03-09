package br.com.erp.sapx.controller.converter;

import br.com.erp.sapx.controller.resource.ProjetoResource;
import br.com.erp.sapx.domain.Project;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProjetoToProjetoResourceConverter {

    private final ModelMapper modelMapper;

    public ProjetoResource convert(Project project){ return modelMapper.map(project, ProjetoResource.class); }
}
