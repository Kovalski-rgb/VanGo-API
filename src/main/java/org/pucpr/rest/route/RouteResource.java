package org.pucpr.rest.route;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.pucpr.rest.route.DTO.CreateRouteDTO;
import org.pucpr.rest.route.response.RouteResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/routes")
public class RouteResource {

    private final RouteService service;

    public RouteResource(RouteService service) {
        this.service = service;
    }

    @PostMapping("/new")
    @Transactional
    public ResponseEntity<RouteResponseDTO> addRoute(
        @Valid @RequestBody CreateRouteDTO request
        ){
            return ResponseEntity.ok(service.createRoute(request));
        }

    @GetMapping("/all")
    @Transactional
    public ResponseEntity<List<RouteResponseDTO>> getAllRoutes(){
        return ResponseEntity.ok(service.getAllRoutes());
    }

}
