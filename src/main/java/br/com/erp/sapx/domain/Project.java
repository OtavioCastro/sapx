package br.com.erp.sapx.domain;

import br.com.erp.sapx.controller.resource.ProjectHoursResource;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    private String id;
    private Integer numProjeto;
    private Client cliente;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Double valor;
    private String status;
    private ProjectHours horasProjeto;
}
