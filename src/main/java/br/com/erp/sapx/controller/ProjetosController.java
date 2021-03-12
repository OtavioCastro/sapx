package br.com.erp.sapx.controller;

import br.com.erp.sapx.controller.converter.ClienteToClienteResourceConverter;
import br.com.erp.sapx.controller.converter.InsertProjectRequestResourceToInsertProjectRequestConverter;
import br.com.erp.sapx.controller.converter.ProjetoToProjetoResourceConverter;
import br.com.erp.sapx.controller.resource.InsertProjectRequestResource;
import br.com.erp.sapx.controller.resource.ProjetoResource;
import br.com.erp.sapx.usecase.projects.FindAllProjectsUseCase;
import br.com.erp.sapx.usecase.projects.InsertProjectUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

@AllArgsConstructor
@RestController
@RequestMapping("/projects")
public class ProjetosController {

    private final FindAllProjectsUseCase findAllProjectsUseCase;
    private final InsertProjectUseCase insertProjectUseCase;
    private final ClienteToClienteResourceConverter toClienteResourceConverter;
    private final ProjetoToProjetoResourceConverter toProjetoResourceConverter;
    private final InsertProjectRequestResourceToInsertProjectRequestConverter toInsertProjectRequestConverter;

    @GetMapping
    public List<ProjetoResource> findAllProjects(){
        return findAllProjectsUseCase.execute()
                .stream()
                .map(toProjetoResourceConverter::convert)
                .collect(toList());
    }

    @PostMapping
    public ProjetoResource insertProject(@RequestBody InsertProjectRequestResource request){
        return of(request)
                .map(toInsertProjectRequestConverter::convert)
                .map(insertProjectUseCase::execute)
                .map(toProjetoResourceConverter::convert)
                .orElseGet(ProjetoResource::new);
    }

}
