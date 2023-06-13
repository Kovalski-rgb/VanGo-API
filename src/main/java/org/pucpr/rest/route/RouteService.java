package org.pucpr.rest.route;

import org.pucpr.rest.route.DTO.CreateRouteDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RouteService {

    private final RouteRepository repository;

    public RouteService(RouteRepository repository) {
        this.repository = repository;
    }

    public void addRoute(CreateRouteDTO request){

        var aux = new Route();
        aux.setPrice(request.getPrice());
        aux.setStreetArrival(request.getStreetArrival());
        aux.setStreetDeparture(request.getStreetDeparture());
        aux.setTimeArrival(LocalDateTime.now());
        aux.setTimeDeparture(LocalDateTime.now());

        repository.save(aux);

    }

    public List<Route> getAllRoutes(){
        var aux = repository.findAll();
        for(Route r : aux){
            r.setDriver(null);
        }
        return aux;
    }

}
