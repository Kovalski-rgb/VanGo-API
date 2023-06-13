package org.pucpr.rest.user.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDTO {


    @Schema(example = "Jeremias")
    @NotNull
    String username;

    @Schema(example = "Senha123")
    @NotNull
    String password;

}
