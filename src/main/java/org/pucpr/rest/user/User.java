package org.pucpr.rest.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.pucpr.rest.user.request.CreateUserDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity @Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String username;

    @NotNull
    private String password;

    public User(CreateUserDTO request) {
        this.username = request.getUsername();
        this.password = new BCryptPasswordEncoder().encode(request.getPassword());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
