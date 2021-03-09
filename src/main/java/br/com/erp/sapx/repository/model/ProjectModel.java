package br.com.erp.sapx.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectModel {

    @Id
    private String id;

    private Long numProjeto;
    private ClientModel cliente;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Double valor;
}
