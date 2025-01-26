package ControllerServices.Sevice;

import ControllerServices.Controllers.ControllerDTO.DTO.TransacaoRequestDTO;
import ControllerServices.Infraststructure.Exceptions.UnprrcessabeEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class TransacaoService {

    public final List<TransacaoRequestDTO> listaDeTransacoes = new ArrayList<>();


    public void adicionarTransacoes(TransacaoRequestDTO dto) {
        log.info("Iniciado o processo de gravação da Transação"+dto);

        if (dto.dataHora().isAfter(OffsetDateTime.now())) {
            log.error("Data e hora maiores que a atuais");

            throw new UnprrcessabeEntity("Data e hora maiores que a atuais");

        }

            if(dto.valor() < 0){
                log.error("Trasaçao não pode ser menor que ZERO");
                throw new UnprrcessabeEntity("Trasaçao não pode ser menor que ZERO");
        }
     listaDeTransacoes.add(dto);
                log.info("Transação adicionada com sucesso, no valor de:" +dto);

    }

    public void limparTransacoes(){
        log.info("Inicido o deletar das transações");

        listaDeTransacoes.clear();
        log.info("Lista de transações deletadas");
    }

    public List<TransacaoRequestDTO> buscarTransacoes(Integer intervaloDeTempo){
        log.info("Iniciado busca po intervalo de tempo");

        OffsetDateTime dataHoraintervalo = OffsetDateTime.now().minusSeconds(intervaloDeTempo);
        log.info("Retorno das lista com sucesso");
        return listaDeTransacoes.stream().filter(transacoes -> transacoes.dataHora()
                .isAfter(dataHoraintervalo)).toList();
    }

}
