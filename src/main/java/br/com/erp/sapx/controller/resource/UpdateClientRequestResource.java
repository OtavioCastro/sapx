package br.com.erp.sapx.controller.resource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateClientRequestResource {
    private String nome;
    private String cnpj;
}
