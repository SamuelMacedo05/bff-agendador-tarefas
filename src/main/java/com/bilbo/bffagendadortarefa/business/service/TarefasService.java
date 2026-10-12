package com.bilbo.bffagendadortarefa.business.service;



import com.bilbo.bffagendadortarefa.business.dto.in.TarefasDTORequest;
import com.bilbo.bffagendadortarefa.business.dto.out.TarefasDTOResponse;
import com.bilbo.bffagendadortarefa.business.enums.StatusNotificacaoEnum;
import com.bilbo.bffagendadortarefa.infrastructure.TarefasClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasClient client;


    public TarefasDTOResponse gravarTarefa(String token, TarefasDTORequest dto) {
        return client.gravarTarefas(dto,token);
    }



    public List<TarefasDTOResponse> buscaTarefasAgendadasPorPeriodo(LocalDateTime dataInicial,
                                                                   LocalDateTime dataFinal,
                                                                   String token) {
        return client.buscalistaPorPeriodo(dataInicial,dataFinal,token);
    }

    public List<TarefasDTOResponse> buscaTarefasPorEmail(String token) {
        return client.buscaTarefasPorEmail(token);
    }


    public void deletarTarefasPorId(String id,String token) {
      client.deletarTarefasPorId(id,token);

    }


    public TarefasDTOResponse alterarStatus(StatusNotificacaoEnum status, String id, String token) {

        return client.alterarStatusDeNotificacao(id, status, token);
    }

    public TarefasDTOResponse updateTarefas(TarefasDTORequest dto, String id, String token) {
        return client.updateTarefas(dto, id, token);
    }

}
