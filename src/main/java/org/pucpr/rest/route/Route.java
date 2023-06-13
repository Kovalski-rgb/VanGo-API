package org.pucpr.rest.route;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.pucpr.rest.driver.Driver;
import org.pucpr.rest.route.DTO.CreateRouteDTO;

import java.time.LocalDateTime;

@Data @Entity
@AllArgsConstructor
@NoArgsConstructor
public class Route {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private Double price;

    @NotNull
    private String streetDeparture;
    @NotNull
    private String streetArrival;

    @NotNull
    private LocalDateTime timeDeparture;
    @NotNull
    private LocalDateTime timeArrival;

    @NotNull
    @ManyToOne
    @JoinTable(
            name="driverRoutes",
            joinColumns = @JoinColumn(name="routeId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="driverId", referencedColumnName = "id")
    )
    private Driver driver;

    public Route(CreateRouteDTO request) {
        this.setPrice(request.getPrice());
        this.setStreetArrival(request.getStreetArrival());
        this.setStreetDeparture(request.getStreetDeparture());
        this.setTimeArrival(LocalDateTime.now());
        this.setTimeDeparture(LocalDateTime.now());
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", price=" + price +
                ", streetDeparture='" + streetDeparture + '\'' +
                ", streetArrival='" + streetArrival + '\'' +
                ", timeDeparture=" + timeDeparture +
                ", timeArrival=" + timeArrival +
                ", driver=" + driver +
                '}';
    }
}
