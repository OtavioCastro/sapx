package br.com.erp.sapx.controller.converter;

import br.com.erp.sapx.controller.resource.UpdateProjectRequestResource;
import br.com.erp.sapx.domain.UpdateProjectRequest;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdateProjectRequestResourceToUpdateProjectRequestConverter {

    private final ModelMapper modelMapper;

    public UpdateProjectRequest convert(UpdateProjectRequestResource updateProjectRequestResource){
        return modelMapper.map(updateProjectRequestResource, UpdateProjectRequest.class);
    }

}
