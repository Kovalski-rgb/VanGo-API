package org.pucpr.rest.driver.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.pucpr.rest.route.Route;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverAndRouteDTO {


    @Schema(example = "Jeremias")
    @NotNull
    private String name;


    @Schema(example = "Fiat uno mili")
    @NotNull
    private String vehicle;


    @Schema(example = "170")
    @NotNull
    private Double price;


    @Schema(example = "4.8")
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
