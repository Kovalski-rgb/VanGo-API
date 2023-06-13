package org.pucpr.rest.route.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRouteDTO {

    @Schema(example = "1")
    @NotNull
    private Long driverId;


    @Schema(example = "150")
    @NotNull
    private Double price;


    @Schema(example = "Ponto de Partida")
    @NotNull
    private String streetDeparture;


    @Schema(example = "Ponto de Chegada")
    @NotNull
    private String streetArrival;

}
