package ControllerServices.Service;

import ControllerServices.Controllers.ControllerDTO.DTO.EstatisticasResponseDto;
import ControllerServices.Controllers.ControllerDTO.DTO.TransacaoRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EstatisticasService {

    private final TransacaoService transacaoService;

    public EstatisticasResponseDto calcularEstatisticas(Integer intervaloDeTempo) {
        List<TransacaoRequestDTO> transacoes = transacaoService.buscarTransacoes(intervaloDeTempo);

        if (transacoes.isEmpty()) {
            return new EstatisticasResponseDto(0L, 0.0, 0.0, 0.0, 0.0);
        }

        DoubleSummaryStatistics estatisticasTransacoes = transacoes.stream()
                .mapToDouble(TransacaoRequestDTO::valor)
                .summaryStatistics();

        return new EstatisticasResponseDto(
                estatisticasTransacoes.getCount(),
                estatisticasTransacoes.getSum(),
                estatisticasTransacoes.getAverage(),
                estatisticasTransacoes.getMin(),
                estatisticasTransacoes.getMax()
        );
    }
}
