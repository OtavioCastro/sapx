package br.com.erp.sapx.controller.resource;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProjectHoursResource {
    private Integer gerentes;
    private Integer coordenadores;
    private Integer arquitetos;
    private Integer progSr;
    private Integer progPl;
    private Integer progJr;
    private Integer dba;
}
