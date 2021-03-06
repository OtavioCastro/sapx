package br.com.erp.sapx.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Projeto {
    private Integer numProjeto;
    private Cliente cliente;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private Double valor;
}
