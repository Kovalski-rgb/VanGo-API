package org.pucpr.rest.driver;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.pucpr.rest.driver.DTO.CreateDriverDTO;
import org.pucpr.rest.driver.DTO.DriverAndRouteDTO;
import org.pucpr.rest.route.DTO.DriverRequestByRouteDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverResource {

    private final DriverService service;

    public DriverResource(DriverService service) {
        this.service = service;
    }

    @PostMapping("/find")
    @Transactional
    public ResponseEntity<List<DriverAndRouteDTO>> getDriverByRoute(
            @Valid @RequestBody DriverRequestByRouteDTO request
    ){
        var returnValue = new DriverAndRouteDTO("jeremias", "fiat com escada", 125D, 5D);
        return ResponseEntity.ok(service.findDriverByRoute(request));
    }

    @PostMapping("/new")
    @Transactional
    public void createNewDriver(
            @Valid @RequestBody CreateDriverDTO request
    ){
        service.saveDriver(request);

    }

}
