package br.com.erp.sapx.controller;

import br.com.erp.sapx.controller.converter.ClienteToClienteResourceConverter;
import br.com.erp.sapx.controller.converter.ProjetoToProjetoResourceConverter;
import br.com.erp.sapx.controller.resource.ProjetoResource;
import br.com.erp.sapx.usecase.projects.FindAllProjectsUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@AllArgsConstructor
@RestController
@RequestMapping("/projetos")
public class ProjetosController {

    private final FindAllProjectsUseCase findAllProjectsUseCase;
    private final ClienteToClienteResourceConverter toClienteResourceConverter;
    private final ProjetoToProjetoResourceConverter toProjetoResourceConverter;

    @GetMapping
    public List<ProjetoResource> findAllProjects(){
        return findAllProjectsUseCase.execute()
                .stream()
                .map(toProjetoResourceConverter::convert)
                .collect(toList());
    }

}
