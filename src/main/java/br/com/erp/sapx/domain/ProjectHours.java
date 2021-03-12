package br.com.erp.sapx.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectHours {
    private Integer gerentes;
    private Integer coordenadores;
    private Integer arquitetos;
    private Integer progSr;
    private Integer progPl;
    private Integer progJr;
    private Integer dba;
}
