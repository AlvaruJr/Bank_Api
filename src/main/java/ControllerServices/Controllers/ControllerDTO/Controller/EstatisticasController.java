package ControllerServices.Controllers.ControllerDTO.Controller;

import ControllerServices.Controllers.ControllerDTO.DTO.EstatisticasResponseDto;
import ControllerServices.Service.EstatisticasService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
@RequiredArgsConstructor
public class EstatisticasController {
    private final EstatisticasService estatisticasService; // Nome corrigido

    @GetMapping
    @Operation(summary = "Busca de transações", description = "Endpoint responsável por buscar estatísticas de transações com base no intervalo de tempo.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Estatísticas obtidas com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro nos parâmetros fornecidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ResponseEntity<EstatisticasResponseDto> buscarEstatisticas(
            @RequestParam(value = "intervaloDeBusca", required = false, defaultValue = "60") Integer intervaloDeBusca) {
        return ResponseEntity.ok(estatisticasService.calcularEstatisticas(intervaloDeBusca)); // Método renomeado
    }
}