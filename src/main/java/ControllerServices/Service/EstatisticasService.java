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

    public final TransacaoService transacaoService;

    public EstatisticasResponseDto calcularEstatisticas(Integer intervaloDeTempo) { // Método renomeado
        List<TransacaoRequestDTO> transacoes = transacaoService.buscarTransacoes(intervaloDeTempo);
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