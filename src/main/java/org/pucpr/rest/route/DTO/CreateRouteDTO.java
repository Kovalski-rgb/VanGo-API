package org.pucpr.rest.route.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRouteDTO {

    @NotNull
    private Long driverId;

    @NotNull
    private Double price;

    @NotNull
    private String streetDeparture;

    @NotNull
    private String streetArrival;

}
