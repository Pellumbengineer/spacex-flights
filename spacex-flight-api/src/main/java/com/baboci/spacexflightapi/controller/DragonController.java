package com.baboci.spacexflightapi.controller;

import com.baboci.spacexflightapi.service.DragonService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dragons")
public class DragonController {

    final DragonService dragonService;

    public DragonController(DragonService dragonService) {
        this.dragonService = dragonService;
    }

    @Operation(summary = "Get total time spent in space of all Dragon flights")
    @GetMapping("/totalTime")
    public ResponseEntity<?> getTotalTimeInSpaceOfAllDragonFlights(){
        int totalTime = dragonService.totalTimeInSpaceOfAllDragonFlights();
        return ResponseEntity.ok().body("Total time spent in space of all Dragon flights: "+ totalTime +" years" );
    }
}