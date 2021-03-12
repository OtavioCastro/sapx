package br.com.erp.sapx.controller;

import br.com.erp.sapx.controller.converter.InsertProjectRequestResourceToInsertProjectRequestConverter;
import br.com.erp.sapx.controller.converter.ProjetoToProjetoResourceConverter;
import br.com.erp.sapx.controller.resource.InsertProjectRequestResource;
import br.com.erp.sapx.controller.resource.ProjectResource;
import br.com.erp.sapx.usecase.projects.DeleteProjectUseCase;
import br.com.erp.sapx.usecase.projects.FindAllProjectsUseCase;
import br.com.erp.sapx.usecase.projects.FindProjectByNumProjetoUseCase;
import br.com.erp.sapx.usecase.projects.InsertProjectUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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
    private final FindProjectByNumProjetoUseCase findProjectByNumProjetoUseCase;
    private final DeleteProjectUseCase deleteProjectUseCase;
    private final ProjetoToProjetoResourceConverter toProjetoResourceConverter;
    private final InsertProjectRequestResourceToInsertProjectRequestConverter toInsertProjectRequestConverter;

    @GetMapping
    public List<ProjectResource> findAllProjects(){
        return findAllProjectsUseCase.execute()
                .stream()
                .map(toProjetoResourceConverter::convert)
                .collect(toList());
    }

    @GetMapping("/{numProj}")
    public ProjectResource findByNum(@PathVariable Integer numProj){
        return of(findProjectByNumProjetoUseCase.execute(numProj))
                .map(toProjetoResourceConverter::convert)
                .orElseGet(ProjectResource::new);
    }

    @PostMapping
    public ProjectResource insertProject(@RequestBody InsertProjectRequestResource request){
        return of(request)
                .map(toInsertProjectRequestConverter::convert)
                .map(insertProjectUseCase::execute)
                .map(toProjetoResourceConverter::convert)
                .orElseGet(ProjectResource::new);
    }

    @DeleteMapping("/{numProjeto}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProject(@PathVariable Integer numProjeto){
        deleteProjectUseCase.execute(numProjeto);
    }

}
