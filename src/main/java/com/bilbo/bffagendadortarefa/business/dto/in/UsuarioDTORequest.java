package com.bilbo.bffagendadortarefa.business.dto.in;


import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDTORequest {

    private String name;
    private String email;
    private String password;
    private List<EnderecoDTORequest> enderecos;
    private List<TelefoneDTORequest> telefones;

}
