package org.pucpr.rest.user;

import org.pucpr.rest.user.request.CreateUserDTO;
import org.pucpr.rest.user.request.LoginRequestDTO;
import org.pucpr.rest.user.response.UserResponseDTO;
import org.pucpr.settings.exceptions.ForbiddenException;
import org.pucpr.settings.exceptions.NotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public UserResponseDTO saveNewUser(CreateUserDTO request){
        if(repository.findByUsername(request.getUsername()) != null){
            throw new ForbiddenException("This username is already in use");
        }
        var aux = repository.save(new User(request));
        return new UserResponseDTO(aux.getId(), aux.getUsername());
    }

    public UserResponseDTO login(LoginRequestDTO request){
        var user = repository.findByUsername(request.getUsername());
        if(user == null) throw new NotFoundException("Wrong email  or password");
        var passwordMatches = new BCryptPasswordEncoder().matches(request.getPassword(), user.getPassword());
        if(!passwordMatches) throw new NotFoundException("Wrong email  or password");
        return new UserResponseDTO(user.getId(), user.getUsername());
    }

}
