package com.baboci.spacexflightapi.controller;

import com.baboci.spacexflightapi.service.RocketService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("rockets")
public class RocketController {

    final RestTemplate restTemplate;

    final RocketService rocketService;

    public RocketController(RestTemplate restTemplate, RocketService rocketService) {
        this.restTemplate = restTemplate;
        this.rocketService = rocketService;
    }

    @Operation(summary = "Get total load of all rockets")
    @GetMapping("/load")
    public ResponseEntity<?> getTotalLoadUsingAllRockets(){
        int totalLoad = rocketService.totalLoadSentOfAllRockets();
        return ResponseEntity.ok().body("Total load sent to space using all rockets: "+ totalLoad + " kg");
    }

    @Operation(summary = "Get total load of Falcon rockets")
    @GetMapping("/load/falcon")
    public ResponseEntity<?> getTotalLoadUsingFalcon(){
        int totalLoad = rocketService.totalLoadSentOfFalconRockets();
        return ResponseEntity.ok().body("Total load sent to space using Falcon: "+ totalLoad + " kg");
    }

    @Operation(summary = "Get overall success rate")
    @GetMapping("/successRate")
    public ResponseEntity<?> getOverallSuccessRate() {
        float successRateOfAllRockets = rocketService.successRateOfAllRockets();
        return ResponseEntity.ok().body("Overall success rate: "+ successRateOfAllRockets + "%");
    }
}
