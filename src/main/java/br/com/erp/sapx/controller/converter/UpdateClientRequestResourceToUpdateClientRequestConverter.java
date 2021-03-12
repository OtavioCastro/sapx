package br.com.erp.sapx.controller.converter;

import br.com.erp.sapx.controller.resource.UpdateClientRequestResource;
import br.com.erp.sapx.domain.UpdateClientRequest;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdateClientRequestResourceToUpdateClientRequestConverter {

    private final ModelMapper modelMapper;

    public UpdateClientRequest convert(UpdateClientRequestResource updateClientRequestResource){
        return modelMapper.map(updateClientRequestResource, UpdateClientRequest.class);
    }
}
