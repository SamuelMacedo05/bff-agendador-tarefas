package com.bilbo.bffagendadortarefa.infrastructure.security;


import com.bilbo.bffagendadortarefa.business.dto.out.TarefasDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(name = "notificacao", url = "${notificacao.url}")
public interface EmailClient {

    void enviarEmail (@RequestBody TarefasDTOResponse dto);
}