package org.pucpr.rest.route.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.pucpr.rest.route.Route;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteResponseDTO {

    private int id;

    private Double price;

    private String streetDeparture;

    private String streetArrival;

    private LocalDateTime timeDeparture;

    private LocalDateTime timeArrival;

    private int driverId;

    public RouteResponseDTO(Route route) {
        this.id = route.getId();
        this.price = route.getPrice();
        this.streetDeparture = route.getStreetDeparture();
        this.streetArrival = route.getStreetArrival();
        this.timeDeparture = route.getTimeDeparture();
        this.timeArrival = route.getTimeArrival();
        this.driverId = route.getDriver().getId();
    }
}
