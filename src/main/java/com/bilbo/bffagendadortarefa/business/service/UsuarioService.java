package com.bilbo.bffagendadortarefa.business.service;


import com.bilbo.bffagendadortarefa.business.dto.in.EnderecoDTORequest;
import com.bilbo.bffagendadortarefa.business.dto.in.LoginRequestDTO;
import com.bilbo.bffagendadortarefa.business.dto.in.TelefoneDTORequest;
import com.bilbo.bffagendadortarefa.business.dto.in.UsuarioDTORequest;
import com.bilbo.bffagendadortarefa.business.dto.out.EnderecoDTOResponse;
import com.bilbo.bffagendadortarefa.business.dto.out.TelefoneDTOResponse;
import com.bilbo.bffagendadortarefa.business.dto.out.UsuarioDTOResponse;
import com.bilbo.bffagendadortarefa.infrastructure.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient client;


    public UsuarioDTOResponse salvarUsuario(UsuarioDTORequest usuarioDTO) {

        return client.salvarUsuario(usuarioDTO);
    }

    public String loginUsuario(LoginRequestDTO dto){
        return client.login(dto);
    }


    public void deletarUsuarioporEmail(String email, String token) {
        client.deletarUsuario(email,token);
    }

    public UsuarioDTOResponse buscarUsuarioPorEmail(String email, String token) {
        return client.BuscarUsuarioPorEmail(email,token);
    }



    public UsuarioDTOResponse atualizarDadosUsuario(String token, UsuarioDTORequest dto) {
        return client.atualizarUsuario(dto,token);

    }

    public EnderecoDTOResponse atulizarEndereco(long idEndereco, EnderecoDTORequest dto, String token) {
        return client.atualizarEndereco(dto,idEndereco,token);
    }

    public TelefoneDTOResponse atulizarTelefone(long idtelefone, TelefoneDTORequest dto, String token) {
       return client.atualizarTelefone(dto,idtelefone,token);
    }

    public EnderecoDTOResponse cadastrarEndereco(EnderecoDTORequest dto, String token) {
        return client.cadastrarEndereco(dto,token);

    }

    public TelefoneDTOResponse cadastrarTelefone(String token, TelefoneDTORequest dto) {
        return client.cadastrarTelefone(dto,token);

    }


}
