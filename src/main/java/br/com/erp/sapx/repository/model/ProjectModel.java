package br.com.erp.sapx.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class ProjectModel {

    @Id
    private String id;
    private Long numProjeto;
    private ClientModel cliente;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Double valor;
    private String status;
    private HorasProjetoModel horasProjeto;
}
