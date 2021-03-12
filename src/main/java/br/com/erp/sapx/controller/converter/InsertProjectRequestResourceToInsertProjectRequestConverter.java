package br.com.erp.sapx.controller.converter;

import br.com.erp.sapx.controller.resource.InsertProjectRequestResource;
import br.com.erp.sapx.domain.InsertProjectRequest;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InsertProjectRequestResourceToInsertProjectRequestConverter {

    private final ModelMapper modelMapper;

    public InsertProjectRequest convert(InsertProjectRequestResource request){
        return modelMapper.map(request, InsertProjectRequest.class);
    }
}
