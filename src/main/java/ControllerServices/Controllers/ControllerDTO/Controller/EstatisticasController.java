package ControllerServices.Controllers.ControllerDTO.Controller;

import ControllerServices.Controllers.ControllerDTO.DTO.EstatisticasResponseDto;
import ControllerServices.Sevice.EstatisticasSevice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
@RequiredArgsConstructor


public class EstatisticasController {
    private final EstatisticasSevice estatisticasSevice;
    public ResponseEntity<EstatisticasResponseDto> BuscarEstatisticas(
            @RequestParam(value = "intervaloBusca",required = false, defaultValue = "60")Integer intervaloBusca){
        return ResponseEntity.ok(estatisticasSevice.calculoEstatisticas(intervaloBusca));

    }
}
