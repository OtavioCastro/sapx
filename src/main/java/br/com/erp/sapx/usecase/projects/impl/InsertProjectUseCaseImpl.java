package br.com.erp.sapx.usecase.projects.impl;

import br.com.erp.sapx.domain.InsertProjectRequest;
import br.com.erp.sapx.domain.Project;
import br.com.erp.sapx.gateway.ClientGateway;
import br.com.erp.sapx.gateway.ProjectGateway;
import br.com.erp.sapx.usecase.projects.InsertProjectUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import static java.util.Optional.of;
import static java.util.Optional.ofNullable;

@Service
@AllArgsConstructor
public class InsertProjectUseCaseImpl implements InsertProjectUseCase {

    private final ClientGateway clientGateway;
    private final ProjectGateway projectGateway;

    @Override
    public Project execute(InsertProjectRequest request) {

        final var client = ofNullable(clientGateway.findClientByNum(request.getNumCliente()))
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.UNPROCESSABLE_ENTITY, "Cliente do projeto não encontrado"));

        final var project = Project.builder()
                .numProjeto(request.getNumProjeto())
                .cliente(client)
                .dataInicio(request.getDataInicio())
                .dataFim(request.getDataFim())
                .valor(request.getValor())
                .status(request.getStatus())
                .horasProjeto(request.getHorasProjeto())
                .build();

        return of(projectGateway.insertOrUpdateProject(project))
                .orElseThrow(() ->  new HttpClientErrorException(HttpStatus.UNPROCESSABLE_ENTITY, "Não foi possível cadastrar o projeto."));
    }
}
