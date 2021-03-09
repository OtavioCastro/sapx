package br.com.erp.sapx.controller;

import br.com.erp.sapx.controller.converter.ClienteToClienteResourceConverter;
import br.com.erp.sapx.controller.converter.ProjetoToProjetoResourceConverter;
import br.com.erp.sapx.controller.resource.ClienteResource;
import br.com.erp.sapx.usecase.clients.FindAllClientsUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@AllArgsConstructor
@RestController
@RequestMapping("/clients")
public class ClientsController {

    private final FindAllClientsUseCase findAllClientsUseCase;
    private final ClienteToClienteResourceConverter toClienteResourceConverter;
    private final ProjetoToProjetoResourceConverter toProjetoResourceConverter;

    @GetMapping
    public List<ClienteResource> findAllProjects(){
        return findAllClientsUseCase.execute()
                .stream()
                .map(toClienteResourceConverter::convert)
                .collect(toList());
    }

}
