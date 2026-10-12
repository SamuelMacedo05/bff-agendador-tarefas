package com.bilbo.bffagendadortarefa.controller;



import com.bilbo.bffagendadortarefa.business.dto.in.LoginRequestDTO;
import com.bilbo.bffagendadortarefa.business.dto.out.EnderecoDTOResponse;
import com.bilbo.bffagendadortarefa.business.dto.out.TelefoneDTOResponse;
import com.bilbo.bffagendadortarefa.business.dto.out.UsuarioDTOResponse;
import com.bilbo.bffagendadortarefa.business.service.UsuarioService;
import com.bilbo.bffagendadortarefa.business.dto.in.EnderecoDTORequest;
import com.bilbo.bffagendadortarefa.business.dto.in.TelefoneDTORequest;
import com.bilbo.bffagendadortarefa.business.dto.in.UsuarioDTORequest;
import com.bilbo.bffagendadortarefa.infrastructure.security.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
@Tag(name = "Usuário", description = "Cadastro e login e Usuário")
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
public class UsuarioController {

    private final UsuarioService usuarioService;


    @PostMapping
    @Operation(summary = "Salvar Usuários", description = "Cria um novo usuário")
    @ApiResponse(responseCode = "200", description = "Usuário salvo com sucesso")
    @ApiResponse(responseCode = "400", description = "Usuário já cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<UsuarioDTOResponse> salvarUsuario(@RequestBody UsuarioDTORequest usuarioDTO){
        return ResponseEntity.ok(usuarioService.salvarUsuario(usuarioDTO));
    }
    @PostMapping("/login")
    @Operation(summary = "Login de Usuários", description = "Login do usuário")
    @ApiResponse(responseCode = "200", description = "Usuário logado com sucesso")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public String login(@RequestBody LoginRequestDTO usuarioDTO){
        return usuarioService.loginUsuario(usuarioDTO);

    }

    @DeleteMapping("/{email}")
    @Operation(summary = "Deletar Usuários por id", description = "Deleta usuário")
    @ApiResponse(responseCode = "200", description = "Usuário deletado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<Void> deletarUsuario(@PathVariable String email,
                                               @RequestHeader(name ="Authorization", required = false)  String token){

        usuarioService.deletarUsuarioporEmail(email,token);
         return ResponseEntity.ok().build();

    }

    @GetMapping
    @Operation(summary = "Buscar dados de Usuários por Email", description = "Buscar dados do usuário")
    @ApiResponse(responseCode = "200", description = "Usuário encontrado")
    @ApiResponse(responseCode = "404", description = "Usuário não cadastrado ")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<UsuarioDTOResponse> BuscarUsuarioPorEmail(@RequestParam ("email") String email,
                                                                   @RequestHeader(name ="Authorization", required = false)  String token){
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email,token));
    }


    @PutMapping
    @Operation(summary = "Atualizar Dados de Usuários", description = "Atualizar Dados de Usuários")
    @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<UsuarioDTOResponse> atualizarUsuario(@RequestBody UsuarioDTORequest dto,
                                                              @RequestHeader(name ="Authorization", required = false)  String token) {

        return ResponseEntity.ok(usuarioService.atualizarDadosUsuario(token,dto));
    }

    @PutMapping("/endereco")
    @Operation(summary = "Atualiza Endereço de Usuários", description = "Atualiza endereço de usuário")
    @ApiResponse(responseCode = "200", description = "Endereço atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<EnderecoDTOResponse> atualizarEndereco (@RequestBody EnderecoDTORequest dto,
                                                                  @RequestParam("id") Long id,
                                                                  @RequestHeader(name ="Authorization", required = false)  String token) {

        return ResponseEntity.ok(usuarioService.atulizarEndereco(id, dto,token));


    }

    @PutMapping("/telefone")
    @Operation(summary = "Atualiza Endereço de Usuários", description = "Atualiza endereço de usuário")
    @ApiResponse(responseCode = "200", description = "Endereço atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado ")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")

    public ResponseEntity<TelefoneDTOResponse> atualizarTelefone (@RequestBody TelefoneDTORequest dto,
                                                                  @RequestParam ("id") Long id,
                                                                  @RequestHeader(name ="Authorization", required = false)  String token) {

        return ResponseEntity.ok(usuarioService.atulizarTelefone(id,dto,token));

    }

    @PostMapping("/endereco")
    @Operation(summary = "Salva Endereço de Usuários", description = "Salva endereço de usuário")
    @ApiResponse(responseCode = "200", description = "Endereço salvo com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<EnderecoDTOResponse>cadastrarEndereco(@RequestBody EnderecoDTORequest dto,
                                                               @RequestHeader(name ="Authorization", required = false)  String token) {
        return ResponseEntity.ok(usuarioService.cadastrarEndereco(dto,token));
    }

    @PostMapping ("/telefone")
    @Operation(summary = "Salva telefone de Usuários", description = "Salva telefone de usuário")
    @ApiResponse(responseCode = "200", description = "Telefone salvo com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário já cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
     public ResponseEntity<TelefoneDTOResponse> cadastrarTelefone(@RequestBody TelefoneDTORequest dto,
                                                                 @RequestHeader(name ="Authorization", required = false)  String token) {
        return ResponseEntity.ok(usuarioService.cadastrarTelefone(token,dto));
    }
}



