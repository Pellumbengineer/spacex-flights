package com.baboci.spacexflightapi.service;

import com.baboci.spacexflightapi.error.EmptyListException;
import com.baboci.spacexflightapi.model.Dragon;
import com.baboci.spacexflightapi.model.Launches;
import com.baboci.spacexflightapi.model.RocketPayloadWeight;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class DragonServiceImpl implements DragonService {

    final RestTemplate restTemplate;

    public DragonServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private List<Dragon> apiRequest() {
        String URL_DRAGONS = "https://api.spacexdata.com/v4/dragons";
        Dragon[] dragonArray = restTemplate.getForObject(URL_DRAGONS, Dragon[].class);
        return Arrays.asList(Objects.requireNonNull(dragonArray));
    }

    @Override
    public int totalTimeInSpaceOfAllDragonFlights() {

        List<Dragon> dragonList = apiRequest();
        if (dragonList.size() == 0){
            throw new EmptyListException("The dragon list is empty!");
        }

        List<Integer> years = dragonList.stream().map(Dragon::getOrbit_duration_yr)
                .collect(Collectors.toList());

        return years.stream().mapToInt(Integer::intValue).sum();
    }
}
