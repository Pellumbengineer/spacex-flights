package com.baboci.spacexflightapi.service;

import com.baboci.spacexflightapi.error.EmptyListException;
import com.baboci.spacexflightapi.model.Rocket;
import com.baboci.spacexflightapi.model.RocketPayloadWeight;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class RocketServiceImpl implements RocketService {

    final RestTemplate restTemplate;

    public RocketServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private List<Rocket> apiRequest() {
        String URL_ROCKETS = "https://api.spacexdata.com/v4/rockets";
        Rocket[] rocketsArray = restTemplate.getForObject(URL_ROCKETS, Rocket[].class);
        return Arrays.asList(Objects.requireNonNull(rocketsArray));
    }

    @Override
    public int totalLoadSentOfAllRockets() {
        List<Rocket> rockets = apiRequest();
        if (rockets.size() == 0){
            throw new EmptyListException("The rockets list is empty!");
        }

        List<Integer> kgs = rockets.stream().map(rocket -> {
            if (rocket.getPayload_weights().size() == 0){
                throw new EmptyListException("The rockets payload weight list is empty!");
            }
            List<Integer> kgsOfRocket = rocket.getPayload_weights().stream().map(RocketPayloadWeight::getKg).collect(Collectors.toList());
            return kgsOfRocket.stream().mapToInt(Integer::intValue).sum();
        }) .collect(Collectors.toList());

        return kgs.stream().mapToInt(Integer::intValue).sum();
    }

    @Override
    public int totalLoadSentOfFalconRockets() {

        List<Rocket> rockets = apiRequest();
        if (rockets.size() == 0){
            throw new EmptyListException("The rockets list is empty!");
        }
        List<Integer> kgs = rockets.stream().map(rocket -> {
            if (rocket.getName().contains("Falcon")){
                if (rocket.getPayload_weights().size() == 0){
                    throw new EmptyListException("The rockets payload weight list is empty!");
                }
                List<Integer> kgsOfRocket = rocket.getPayload_weights().stream().map(RocketPayloadWeight::getKg).collect(Collectors.toList());
                return kgsOfRocket.stream().mapToInt(Integer::intValue).sum();
            }
            return 0;
        }) .collect(Collectors.toList());
        return kgs.stream().mapToInt(Integer::intValue).sum();
    }

    @Override
    public float successRateOfAllRockets() {
        List<Rocket> rockets = apiRequest();

        if (rockets.size() == 0){
            throw new EmptyListException("The rockets list is empty!");
        }

        List<Integer> percentages = rockets.stream().map(Rocket::getSuccess_rate_pct)
                .collect(Collectors.toList());

        float totalPct = (float) percentages.stream().mapToInt(Integer::intValue).sum() / percentages.size();
        System.out.println(totalPct);
        return totalPct;
    }
}
