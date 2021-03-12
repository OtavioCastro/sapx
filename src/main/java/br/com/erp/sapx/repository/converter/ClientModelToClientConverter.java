package br.com.erp.sapx.repository.converter;

import br.com.erp.sapx.domain.Client;
import br.com.erp.sapx.repository.model.ClientModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ClientModelToClientConverter {

    private final ModelMapper modelMapper;

    public Client convert(ClientModel clientModel){
        return modelMapper.map(clientModel, Client.class);
    }
}
