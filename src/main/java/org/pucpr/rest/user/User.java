package org.pucpr.rest.user;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @NotNull
    private String username;

    @NotNull
    private String password;

}
