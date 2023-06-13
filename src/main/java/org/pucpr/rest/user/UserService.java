package org.pucpr.rest.user;

import org.pucpr.rest.user.request.CreateUserDTO;
import org.pucpr.rest.user.response.UserResponseDTO;
import org.pucpr.settings.exceptions.ForbiddenException;
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
        var aux = new User();
        aux.setUsername(request.getUsername());
        aux.setPassword(request.getPassword());
        aux = repository.save(aux);
        return new UserResponseDTO(aux.getId(), aux.getUsername());
    }

}
