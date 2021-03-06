package br.com.erp.sapx.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    private String id;
    private Integer numCliente;
    private String nome;
    private String cnpj;
}
