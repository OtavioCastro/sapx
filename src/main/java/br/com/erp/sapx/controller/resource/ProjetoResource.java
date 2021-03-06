package br.com.erp.sapx.controller.resource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjetoResource {
    private Integer numProjeto;
    private ClienteResource cliente;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private Double valor;
}
