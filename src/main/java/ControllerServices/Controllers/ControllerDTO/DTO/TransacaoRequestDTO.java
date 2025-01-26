package ControllerServices.Controllers.ControllerDTO.DTO;

import java.time.OffsetDateTime;

public record TransacaoRequestDTO(Double valor, OffsetDateTime dataHora) {
}
