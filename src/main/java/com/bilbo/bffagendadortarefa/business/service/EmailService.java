package com.bilbo.bffagendadortarefa.business.service;


import com.bilbo.bffagendadortarefa.business.dto.out.TarefasDTOResponse;
import com.bilbo.bffagendadortarefa.infrastructure.security.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailClient emailClient;


    public void enviaEmail (TarefasDTOResponse dto) {
        emailClient.enviarEmail(dto);
    }


}
