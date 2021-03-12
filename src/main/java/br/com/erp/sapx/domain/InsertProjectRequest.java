package br.com.erp.sapx.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InsertProjectRequest {
    private Integer numCliente;
    private Integer numProjeto;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Double valor;
    private String status;
    private ProjectHours horasProjeto;
}
