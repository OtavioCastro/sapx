package br.com.erp.sapx.controller.converter;

import br.com.erp.sapx.controller.resource.ClienteResource;
import br.com.erp.sapx.domain.Cliente;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ClienteToClienteResourceConverter {

    private final ModelMapper modelMapper;

    public ClienteResource convert(Cliente cliente){ return modelMapper.map(cliente, ClienteResource.class); }
}
