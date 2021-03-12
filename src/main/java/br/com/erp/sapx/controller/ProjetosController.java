package br.com.erp.sapx.controller;

import br.com.erp.sapx.controller.converter.InsertProjectRequestResourceToInsertProjectRequestConverter;
import br.com.erp.sapx.controller.converter.ProjectToProjectResourceConverter;
import br.com.erp.sapx.controller.converter.UpdateProjectRequestResourceToUpdateProjectRequestConverter;
import br.com.erp.sapx.controller.resource.InsertProjectRequestResource;
import br.com.erp.sapx.controller.resource.ProjectResource;
import br.com.erp.sapx.controller.resource.UpdateProjectRequestResource;
import br.com.erp.sapx.usecase.projects.*;
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
    private final UpdateProjectUseCase updateProjectUseCase;
    private final ProjectToProjectResourceConverter toProjectResourceConverter
            ;
    private final InsertProjectRequestResourceToInsertProjectRequestConverter toInsertProjectRequestConverter;
    private final UpdateProjectRequestResourceToUpdateProjectRequestConverter toUpdateProjectRequestConverter;

    @GetMapping
    public List<ProjectResource> findAllProjects(){
        return findAllProjectsUseCase.execute()
                .stream()
                .map(toProjectResourceConverter::convert)
                .collect(toList());
    }

    @GetMapping("/{numProj}")
    public ProjectResource findByNum(@PathVariable Integer numProj){
        return of(findProjectByNumProjetoUseCase.execute(numProj))
                .map(toProjectResourceConverter::convert)
                .orElseGet(ProjectResource::new);
    }

    @PostMapping
    public ProjectResource insertProject(@RequestBody InsertProjectRequestResource requestBody){
        return of(requestBody)
                .map(toInsertProjectRequestConverter::convert)
                .map(insertProjectUseCase::execute)
                .map(toProjectResourceConverter::convert)
                .orElseGet(ProjectResource::new);
    }

    @DeleteMapping("/{numProjeto}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProject(@PathVariable Integer numProjeto){
        deleteProjectUseCase.execute(numProjeto);
    }

    @PutMapping("/{numProjeto}")
    public ProjectResource updateProject(@PathVariable Integer numProjeto, @RequestBody UpdateProjectRequestResource requestBody){
        return of(requestBody)
                .map(toUpdateProjectRequestConverter::convert)
                .map(request -> updateProjectUseCase.execute(numProjeto, request))
                .map(toProjectResourceConverter::convert)
                .orElseGet(ProjectResource::new);
    }

}
