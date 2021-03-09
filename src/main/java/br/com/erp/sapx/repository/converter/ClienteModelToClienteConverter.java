package br.com.erp.sapx.repository.converter;

import br.com.erp.sapx.domain.Cliente;
import br.com.erp.sapx.repository.model.ClientModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ClienteModelToClienteConverter {

    private final ModelMapper modelMapper;

    public Cliente convert(ClientModel clientModel){ return modelMapper.map(clientModel, Cliente.class); }
}
