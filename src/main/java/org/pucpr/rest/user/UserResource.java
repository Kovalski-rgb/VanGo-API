package org.pucpr.rest.user;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.pucpr.rest.user.request.CreateUserDTO;
import org.pucpr.rest.user.request.LoginRequestDTO;
import org.pucpr.rest.user.response.UserResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class UserResource {

    private final UserService service;

    public UserResource(UserService service) {
        this.service = service;
    }

    @PostMapping("/new")
    @Transactional
    public ResponseEntity<UserResponseDTO> createNewUser(
            @Valid @RequestBody CreateUserDTO request
    ){
        return ResponseEntity.ok(service.saveNewUser(request));
    }

    @PostMapping("/login")
    @Transactional
    public ResponseEntity<UserResponseDTO> login(
            @Valid @RequestBody LoginRequestDTO request
    ){
        return ResponseEntity.ok(service.login(request));
    }

}
