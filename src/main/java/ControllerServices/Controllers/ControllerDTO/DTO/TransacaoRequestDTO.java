package ControllerServices.Controllers.ControllerDTO.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.OffsetDateTime;

public record TransacaoRequestDTO(
        @NotNull @Positive Double valor,
        @NotNull OffsetDateTime dataHora
) {}