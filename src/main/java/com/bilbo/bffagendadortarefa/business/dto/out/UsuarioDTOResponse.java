package com.bilbo.bffagendadortarefa.business.dto.out;


import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDTOResponse {

    private String name;
    private String email;
    private String password;
    private List<EnderecoDTOResponse> enderecos;
    private List<TelefoneDTOResponse> telefones;

}
