package br.com.erp.sapx.usecase.projects.impl;

import br.com.erp.sapx.domain.Project;
import br.com.erp.sapx.gateway.ProjectGateway;
import br.com.erp.sapx.usecase.projects.FindProjectByNumProjetoUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import static java.util.Optional.ofNullable;

@Service
@AllArgsConstructor
public class FindProjectByNumProjetoUseCaseImpl implements FindProjectByNumProjetoUseCase {

    private final ProjectGateway gateway;

    @Override
    public Project execute(Integer numProjeto) {
        return ofNullable(gateway.findProjectByNumProjeto(numProjeto))
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Projeto n°" + numProjeto + " não encontrado."));
    }
}
