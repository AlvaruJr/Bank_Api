package ControllerServices.Controllers.ControllerDTO.Controller;

import ControllerServices.Controllers.ControllerDTO.DTO.TransacaoRequestDTO;
import ControllerServices.Service.TransacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/transacao")
@RestController
@ApiResponse

public class TransacaoController {

private final TransacaoService transacaoService;

    @PostMapping
    @Operation(description = "Enpoint responsavel por Adicinar transação")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Transação adicionada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de requisição"),
            @ApiResponse(responseCode = "422", description = "Erro nos parâmetros fornecidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ResponseEntity<Void> adicionarTransacao(@RequestBody TransacaoRequestDTO dto){
        transacaoService.adicionarTransacoes(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping
    @Operation(description = "Endpoint responsável por buscar estatísticas de transações com base no intervalo de tempo.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Estatísticas obtidas com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro nos parâmetros fornecidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ResponseEntity<Void> deletarTransacoes(){
        transacaoService.limparTransacoes();
        return ResponseEntity.ok().build();
    }
}
