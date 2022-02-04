package com.baboci.spacexflightapi.service;

import com.baboci.spacexflightapi.error.EmptyListException;
import com.baboci.spacexflightapi.model.Launches;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class LaunchesServiceImpl implements LaunchesService{
    final RestTemplate restTemplate;

    public LaunchesServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private List<Launches> apiRequest() {
        String URL_LAUNCHES = "https://api.spacexdata.com/v4/launches";
        Launches[] launchesArray = restTemplate.getForObject(URL_LAUNCHES, Launches[].class);
        return Arrays.asList(Objects.requireNonNull(launchesArray));
    }

    @Override
    public int totalLaunches() {
        List<Launches> launchesList = apiRequest();
        if (launchesList.size() == 0){
            throw new EmptyListException("The launches list is empty!");
        }
        return launchesList.size();
    }

    @Override
    public int successfulLaunches() {
        List<Launches> launchesList = apiRequest();
        if (launchesList.size() == 0){
            throw new EmptyListException("The launches list is empty!");
        }
        List<Integer> successfulLaunches = launchesList
                .stream()
                .map(launches -> {
                    // if success field is null I want to proceed and assume that this launch is not successful
                    if (launches.getSuccess() == null){
                        return 0;
                    }
                    if (launches.getSuccess()){
                        return 1;
                    }
                    return 0;
        }).collect(Collectors.toList());
        return successfulLaunches
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
