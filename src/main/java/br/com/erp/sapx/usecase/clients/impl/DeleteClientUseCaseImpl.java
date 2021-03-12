package br.com.erp.sapx.usecase.clients.impl;

import br.com.erp.sapx.gateway.ClientGateway;
import br.com.erp.sapx.gateway.ProjectGateway;
import br.com.erp.sapx.usecase.clients.DeleteClientUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

import static java.util.Optional.of;
import static java.util.Optional.ofNullable;

@Service
@AllArgsConstructor
public class DeleteClientUseCaseImpl implements DeleteClientUseCase {

    private final ClientGateway clientGateway;
    private final ProjectGateway projectGateway;

    @Override
    public void execute(Integer numCliente) {
        final var client = ofNullable(clientGateway.findClientByNum(numCliente))
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));

        of(projectGateway.findAllProjectsByIdCliente(client.getId()))
                .filter(List::isEmpty)
                .orElseThrow(() -> new HttpClientErrorException(
                        HttpStatus.UNPROCESSABLE_ENTITY, "Cliente possui projetos cadastrados, não será possível excluir seu cadastro.")
                );

        clientGateway.deleteClient(client.getId());
    }
}
