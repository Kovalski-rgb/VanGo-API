package org.pucpr.rest.driver;

import org.pucpr.rest.driver.DTO.CreateDriverDTO;
import org.pucpr.rest.driver.DTO.DriverAndRouteDTO;
import org.pucpr.rest.route.DTO.DriverRequestByRouteDTO;
import org.pucpr.rest.route.Route;
import org.pucpr.rest.route.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverService {

    private final DriverRepository repository;
    private final RouteRepository routeRepository;

    public DriverService(DriverRepository repository, RouteRepository routeRepository) {
        this.repository = repository;
        this.routeRepository = routeRepository;
    }

    public List<DriverAndRouteDTO> findDriverByRoute(DriverRequestByRouteDTO request){
        var allRoutes = routeRepository.findAll();

        for(Route r : allRoutes){
            System.out.println(r);
        }

        return allRoutes.stream().filter(r ->
                r.getStreetDeparture().equals(request.getStreetDeparture()) ||
                r.getStreetArrival().equals(request.getStreetArrival()))
                .map(r -> {
                    DriverAndRouteDTO result;
                    if(r.getDriver() == null){
                        result = new DriverAndRouteDTO(
                        "unknown",
                        "unknown",
                                r.getPrice(),
                                0.0);
                    }else{
                        result = new DriverAndRouteDTO(
                            r.getDriver().getName(),
                            r.getDriver().getVehicle(),
                            r.getPrice(),
                            r.getDriver().getScore());
                    }
                    return result;
                })
                .toList();
    }

    public void saveDriver(CreateDriverDTO request){
        var aux = new Driver();

        aux.setName(request.getName());
        aux.setVehicle(request.getVehicle());
        aux.setScore(request.getScore());

        repository.save(aux);
    }

}
