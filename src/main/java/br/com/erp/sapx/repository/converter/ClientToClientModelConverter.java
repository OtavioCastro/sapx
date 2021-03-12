package br.com.erp.sapx.repository.converter;

import br.com.erp.sapx.domain.Client;
import br.com.erp.sapx.repository.model.ClientModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ClientToClientModelConverter {
    private final ModelMapper modelMapper;

    public ClientModel convert(Client client){
        return modelMapper.map(client, ClientModel.class);
    }
}
