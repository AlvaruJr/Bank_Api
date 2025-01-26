package ControllerServices.Controllers.ControllerDTO.DTO;

public record EstatisticasResponseDto(long count,
                                      Double sum,  // CORRETO
                                      Double avg,  // CORRETO
                                      Double min,
                                      Double max) {
}
