package com.bilbo.bffagendadortarefa.business.dto.in;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnderecoDTORequest {

    private String rua;
    private String cidade;
    private Double numero;
    private String complemento;
    private String cep;
}
