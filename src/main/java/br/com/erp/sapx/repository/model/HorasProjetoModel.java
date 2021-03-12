package br.com.erp.sapx.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HorasProjetoModel {
    private Integer gerentes;
    private Integer coordenadores;
    private Integer arquitetos;
    private Integer progSr;
    private Integer progPl;
    private Integer progJr;
    private Integer dba;
}
