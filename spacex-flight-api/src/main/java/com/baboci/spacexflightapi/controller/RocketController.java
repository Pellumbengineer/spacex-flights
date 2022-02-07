package com.baboci.spacexflightapi.controller;

import com.baboci.spacexflightapi.model.response.LoadResponse;
import com.baboci.spacexflightapi.model.response.SuccessRateResponse;
import com.baboci.spacexflightapi.service.RocketService;
import io.swagger.v3.oas.annotations.Operation;
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
    public ResponseEntity<?> getTotalLoadUsingAllRocketsInKg(){
        int totalLoad = rocketService.totalLoadSentOfAllRockets();
        LoadResponse loadResponse = new LoadResponse();
        loadResponse.setKg(totalLoad);
        return ResponseEntity.ok().body(loadResponse);
    }

    @Operation(summary = "Get total load of Falcon rockets")
    @GetMapping("/load/falcon")
    public ResponseEntity<?> getTotalLoadUsingFalconInKg(){
        int totalLoad = rocketService.totalLoadSentOfFalconRockets();
        LoadResponse loadResponse = new LoadResponse();
        loadResponse.setKg(totalLoad);
        return ResponseEntity.ok().body(loadResponse);
    }

    @Operation(summary = "Get overall success rate")
    @GetMapping("/successRate")
    public ResponseEntity<?> getOverallSuccessRate() {
        float successRateOfAllRockets = rocketService.successRateOfAllRockets();
        SuccessRateResponse successRateResponse = new SuccessRateResponse();
        successRateResponse.setRate_pct(successRateOfAllRockets);
        return ResponseEntity.ok().body(successRateResponse);
    }
}
