package org.pucpr.rest.driver;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.pucpr.rest.driver.DTO.CreateDriverDTO;
import org.pucpr.rest.driver.DTO.DriverAndRouteDTO;
import org.pucpr.rest.driver.respose.DriverResponseDTO;
import org.pucpr.rest.route.DTO.DriverRequestByRouteDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/drivers")
public class DriverResource {

    private final DriverService service;

    public DriverResource(DriverService service) {
        this.service = service;
    }

    @PostMapping("/find")
    @Transactional
    public ResponseEntity<Set<DriverAndRouteDTO>> getDriverByRoute(
            @Valid @RequestBody DriverRequestByRouteDTO request
    ){
        return ResponseEntity.ok(service.findDriverByRoute(request));
    }

    @PostMapping("/new")
    @Transactional
    public void createNewDriver(
            @Valid @RequestBody CreateDriverDTO request
    ){
        service.saveDriver(request);

    }

    @GetMapping("/all")
    @Transactional
    public ResponseEntity<List<DriverResponseDTO>> getAllDrivers(){
        return ResponseEntity.ok(service.getAllDrivers());
    }

}
