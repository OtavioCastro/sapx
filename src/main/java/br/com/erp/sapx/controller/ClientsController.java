package br.com.erp.sapx.controller;

import br.com.erp.sapx.controller.converter.ClientToClientResourceConverter;
import br.com.erp.sapx.controller.converter.InsertClientRequestResourceToInsertClientRequestConverter;
import br.com.erp.sapx.controller.resource.InsertClientRequestResource;
import br.com.erp.sapx.controller.resource.ClientResource;
import br.com.erp.sapx.usecase.clients.DeleteClientUseCase;
import br.com.erp.sapx.usecase.clients.FindAllClientsUseCase;
import br.com.erp.sapx.usecase.clients.FindClientByNumClienteUseCase;
import br.com.erp.sapx.usecase.clients.InsertClientUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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
    private final FindClientByNumClienteUseCase findClientByNumClienteUseCase;
    private final DeleteClientUseCase deleteClientUseCase;
    private final ClientToClientResourceConverter toClientResourceConverter;
    private final InsertClientRequestResourceToInsertClientRequestConverter toInsertClientRequestConverter;

    @GetMapping
    public List<ClientResource> findAllClients(){
        return findAllClientsUseCase.execute()
                .stream()
                .map(toClientResourceConverter::convert)
                .collect(toList());
    }

    @GetMapping("/{numCliente}")
    public ClientResource findClientByNum(@PathVariable Integer numCliente){
        return of(findClientByNumClienteUseCase.execute(numCliente))
                .map(toClientResourceConverter::convert)
                .orElseGet(ClientResource::new);
    }

    @PostMapping
    public ClientResource insertClient(@RequestBody InsertClientRequestResource request){
        return of(request)
                .map(toInsertClientRequestConverter::convert)
                .map(insertClientUseCase::execute)
                .map(toClientResourceConverter::convert)
                .orElseGet(ClientResource::new);
    }

    @DeleteMapping("/{numCliente}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable Integer numCliente){
        deleteClientUseCase.execute(numCliente);
    }
}
