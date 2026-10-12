package com.bilbo.bffagendadortarefa.infrastructure;



import com.bilbo.bffagendadortarefa.business.dto.in.EnderecoDTORequest;
import com.bilbo.bffagendadortarefa.business.dto.in.LoginRequestDTO;
import com.bilbo.bffagendadortarefa.business.dto.in.TelefoneDTORequest;
import com.bilbo.bffagendadortarefa.business.dto.in.UsuarioDTORequest;
import com.bilbo.bffagendadortarefa.business.dto.out.EnderecoDTOResponse;
import com.bilbo.bffagendadortarefa.business.dto.out.TelefoneDTOResponse;
import com.bilbo.bffagendadortarefa.business.dto.out.UsuarioDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient (name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping("/usuario")
    UsuarioDTOResponse BuscarUsuarioPorEmail(@RequestParam("email") String email,
                                            @RequestHeader("Authorization")String token);

    @PostMapping
    UsuarioDTOResponse salvarUsuario(@RequestBody UsuarioDTORequest usuarioDTO);

    @PostMapping("/login")
    String login(@RequestBody LoginRequestDTO usuarioDTO);



    @DeleteMapping("/{email}")
    void deletarUsuario(@PathVariable String email,
                        @RequestHeader ("Authorization") String token);


    @PutMapping
    UsuarioDTOResponse atualizarUsuario(@RequestBody UsuarioDTORequest dto,
                                       @RequestHeader ("Authorization") String token);

    @PutMapping("/endereco")
    EnderecoDTOResponse atualizarEndereco (@RequestBody EnderecoDTORequest dto,
                                           @RequestParam("id") Long id,
                                           @RequestHeader ("Authorization") String token);

    @PutMapping("/telefone")
    TelefoneDTOResponse atualizarTelefone (@RequestBody TelefoneDTORequest dto,
                                           @RequestParam ("id") Long id,
                                           @RequestHeader ("Authorization") String token);

    @PostMapping("/endereco")
    EnderecoDTOResponse cadastrarEndereco(@RequestBody EnderecoDTORequest dto,
                                         @RequestHeader("Authorization") String token);

    @PostMapping ("/telefone")
    TelefoneDTOResponse cadastrarTelefone(@RequestBody TelefoneDTORequest dto,
                                         @RequestHeader("Authorization") String token);
}
