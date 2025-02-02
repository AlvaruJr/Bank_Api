package ControllerServices.Service;

import ControllerServices.Controllers.ControllerDTO.DTO.TransacaoRequestDTO;
import ControllerServices.Infrastructure.Exceptions.UnprocessableEntity;
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
    private final List<TransacaoRequestDTO> listaDeTransacoes = new ArrayList<>();

    public void adicionarTransacoes(TransacaoRequestDTO dto) {
        log.info("Iniciado o processo de gravação da Transação{}", dto);

        if (dto.dataHora().isAfter(OffsetDateTime.now())) {
            log.error("Data e hora maiores que a atuais");
            throw new UnprocessableEntity("Data e hora maiores que a atuais");
        }

        if (dto.valor() < 0) {
            log.error("Transação não pode ser menor que ZERO");
            throw new UnprocessableEntity("Transação não pode ser menor que ZERO");
        }
        listaDeTransacoes.add(dto);
        log.info("Transação adicionada com sucesso, no valor de:{}", dto);
    }

    public void limparTransacoes() {
        log.info("Iniciado o deletar das transações");
        listaDeTransacoes.clear();
        log.info("Lista de transações deletadas");
    }

    public List<TransacaoRequestDTO> buscarTransacoes(Integer intervaloDeTempo) {
        log.info("Iniciado busca por intervalo de tempo");

        OffsetDateTime dataHoraIntervalo = OffsetDateTime.now().minusSeconds(intervaloDeTempo);
        log.info("Intervalo de busca: {}", dataHoraIntervalo);

        List<TransacaoRequestDTO> transacoesFiltradas = listaDeTransacoes.stream()
                .filter(transacao -> transacao.dataHora().isAfter(dataHoraIntervalo))
                .toList();

        log.info("Número de transações encontradas: {}", transacoesFiltradas.size());
        return transacoesFiltradas;
    }
}
