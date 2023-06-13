package org.pucpr.rest.driver.respose;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.pucpr.rest.driver.Driver;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverResponseDTO {

    private int id;

    private String name;

    private String vehicle;

    private Double score;

    public DriverResponseDTO(Driver driver) {
        this.id = driver.getId();
        this.name = driver.getName();
        this.vehicle = driver.getVehicle();
        this.score = driver.getScore();
    }
}
