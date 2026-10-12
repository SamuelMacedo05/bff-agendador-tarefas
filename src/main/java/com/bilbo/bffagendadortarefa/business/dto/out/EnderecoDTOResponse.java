package com.bilbo.bffagendadortarefa.business.dto.out;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnderecoDTOResponse {

    private String rua;
    private String cidade;
    private Double numero;
    private String complemento;
    private String cep;
}
