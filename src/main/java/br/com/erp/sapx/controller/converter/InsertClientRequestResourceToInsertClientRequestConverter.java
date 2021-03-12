package br.com.erp.sapx.controller.converter;

import br.com.erp.sapx.controller.resource.InsertClientRequestResource;
import br.com.erp.sapx.domain.InsertClientRequest;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InsertClientRequestResourceToInsertClientRequestConverter {

    private final ModelMapper modelMapper;

    public InsertClientRequest convert(InsertClientRequestResource request){
        return modelMapper.map(request, InsertClientRequest.class);
    }

}
