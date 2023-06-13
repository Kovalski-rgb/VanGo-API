package org.pucpr.rest.driver;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.pucpr.rest.route.Route;

import java.util.List;

@Entity @Data
@AllArgsConstructor
@NoArgsConstructor
public class Driver {

    @Id
    @GeneratedValue
    private int id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String vehicle;

    @NotNull
    @Min(0) @Max(5)
    private Double score;

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Route> routes;

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vehicle='" + vehicle + '\'' +
                ", score=" + score +
                '}';
    }
}
