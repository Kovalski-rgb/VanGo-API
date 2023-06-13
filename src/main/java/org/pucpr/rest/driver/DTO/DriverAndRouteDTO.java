package org.pucpr.rest.driver.DTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.pucpr.rest.route.Route;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverAndRouteDTO {

    @NotNull
    private String name;

    @NotNull
    private String vehicle;

    @NotNull
    private Double price;

    @NotNull
    @Min(0) @Max(5)
    private Double driverScore;

    public DriverAndRouteDTO(Route route) {
        var aux = route.getDriver();
        this.name = aux.getName();
        this.vehicle = aux.getVehicle();
        this.price = route.getPrice();
        this.driverScore = aux.getScore();
    }
}
