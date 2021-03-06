package br.com.erp.sapx.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjetoModel {
    private Integer numProjeto;
    private ClienteModel cliente;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private Double valor;
}
