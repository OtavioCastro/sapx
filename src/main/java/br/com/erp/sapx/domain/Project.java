package br.com.erp.sapx.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    private String id;
    private Integer numProjeto;
    private Cliente cliente;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Double valor;
}
