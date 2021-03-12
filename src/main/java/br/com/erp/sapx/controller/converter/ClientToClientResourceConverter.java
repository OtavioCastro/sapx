package br.com.erp.sapx.controller.converter;

import br.com.erp.sapx.controller.resource.ClientResource;
import br.com.erp.sapx.domain.Client;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ClientToClientResourceConverter {

    private final ModelMapper modelMapper;

    public ClientResource convert(Client client){ return modelMapper.map(client, ClientResource.class); }
}
