package org.pucpr.rest.route.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverRequestByRouteDTO {

    @NotNull
    private String streetDeparture;
    @NotNull
    private String streetArrival;

    @NotNull
    private LocalDateTime timeDeparture;
    @NotNull
    private LocalDateTime timeArrival;

}
