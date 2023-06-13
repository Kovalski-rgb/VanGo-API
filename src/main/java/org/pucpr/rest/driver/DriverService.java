package org.pucpr.rest.driver;

import org.pucpr.rest.driver.DTO.CreateDriverDTO;
import org.pucpr.rest.driver.DTO.DriverAndRouteDTO;
import org.pucpr.rest.driver.respose.DriverResponseDTO;
import org.pucpr.rest.route.DTO.DriverRequestByRouteDTO;
import org.pucpr.rest.route.Route;
import org.pucpr.rest.route.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DriverService {

    private final DriverRepository repository;
    private final RouteRepository routeRepository;

    public DriverService(DriverRepository repository, RouteRepository routeRepository) {
        this.repository = repository;
        this.routeRepository = routeRepository;
    }

    public List<DriverResponseDTO> getAllDrivers(){
        return repository.findAll().stream().map(DriverResponseDTO::new).toList();
    }

    public Set<DriverAndRouteDTO> findDriverByRoute(DriverRequestByRouteDTO request){
        return routeRepository.findAll().stream().filter(r ->
                r.getStreetDeparture().equals(request.getStreetDeparture()) ||
                r.getStreetArrival().equals(request.getStreetArrival()))
                .map(DriverAndRouteDTO::new)
                .collect(Collectors.toSet());
    }

    public void saveDriver(CreateDriverDTO request){
        repository.save(new Driver(request));
    }

}
