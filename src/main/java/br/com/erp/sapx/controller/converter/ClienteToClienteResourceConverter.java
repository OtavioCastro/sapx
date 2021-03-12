package br.com.erp.sapx.controller.converter;

import br.com.erp.sapx.controller.resource.ClienteResource;
import br.com.erp.sapx.domain.Client;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ClienteToClienteResourceConverter {

    private final ModelMapper modelMapper;

    public ClienteResource convert(Client client){ return modelMapper.map(client, ClienteResource.class); }
}
