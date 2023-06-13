package org.pucpr.rest.route;

import org.pucpr.rest.driver.DriverRepository;
import org.pucpr.rest.route.DTO.CreateRouteDTO;
import org.pucpr.rest.route.response.RouteResponseDTO;
import org.pucpr.settings.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {

    private final RouteRepository repository;
    private final DriverRepository driverRepository;

    public RouteService(RouteRepository repository, DriverRepository driverRepository) {
        this.repository = repository;
        this.driverRepository = driverRepository;
    }

    public RouteResponseDTO createRoute(CreateRouteDTO request){

        var driverOptional = driverRepository.findById(request.getDriverId());
        if(driverOptional.isEmpty())
            throw new NotFoundException("There is no driver with provided Id");

        var aux = new Route(request);
        aux.setDriver(driverOptional.get());
        return new RouteResponseDTO(repository.save(aux));
    }

    public List<RouteResponseDTO> getAllRoutes(){
        return repository.findAll().stream().map(RouteResponseDTO::new).toList();
    }

}
