package org.pucpr.rest.user.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUser {

    @NotNull
    String username;

    @NotNull
    String password;

}
