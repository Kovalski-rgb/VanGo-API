package org.pucpr.rest.driver.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateDriverDTO {


    @Schema(example = "Jeremias")
    @NotEmpty
    private String name;


    @Schema(example = "Uno Fiat Mili")
    @NotEmpty
    private String vehicle;


    @Schema(example = "4.9")
    @NotNull
    @Min(0) @Max(5)
    private Double score;

}
