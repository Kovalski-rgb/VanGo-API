package org.pucpr.rest.route.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverRequestByRouteDTO {

    @Schema(example = "Ponto de Partida")
    @NotNull
    private String streetDeparture;
    @Schema(example = "Ponto de Destino")
    @NotNull
    private String streetArrival;


    @Schema(example = "2023-06-14T18:51:26.191Z")
    @NotNull
    private LocalDateTime timeDeparture;

    @Schema(example = "2023-06-15T18:51:26.191Z")
    @NotNull
    private LocalDateTime timeArrival;

}
