package br.com.erp.sapx.controller;

import br.com.erp.sapx.controller.converter.ClienteToClienteResourceConverter;
import br.com.erp.sapx.controller.converter.InsertClientRequestResourceToInsertClientRequestConverter;
import br.com.erp.sapx.controller.resource.InsertClientRequestResource;
import br.com.erp.sapx.controller.resource.ClienteResource;
import br.com.erp.sapx.usecase.clients.FindAllClientsUseCase;
import br.com.erp.sapx.usecase.clients.InsertClientUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

@AllArgsConstructor
@RestController
@RequestMapping("/clients")
public class ClientsController {

    private final FindAllClientsUseCase findAllClientsUseCase;
    private final InsertClientUseCase insertClientUseCase;
    private final ClienteToClienteResourceConverter toClienteResourceConverter;
    private final InsertClientRequestResourceToInsertClientRequestConverter toInsertClientRequestConverter;

    @GetMapping
    public List<ClienteResource> findAllClients(){
        return findAllClientsUseCase.execute()
                .stream()
                .map(toClienteResourceConverter::convert)
                .collect(toList());
    }

    @PostMapping
    public ClienteResource insertClient(@RequestBody InsertClientRequestResource request){
        return of(request)
                .map(toInsertClientRequestConverter::convert)
                .map(insertClientUseCase::execute)
                .map(toClienteResourceConverter::convert)
                .orElseGet(ClienteResource::new);
    }

}
