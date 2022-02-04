package com.baboci.spacexflightapi;

import com.baboci.spacexflightapi.controller.LaunchesController;
import com.baboci.spacexflightapi.service.LaunchesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(LaunchesController.class)
public class LaunchesControllerTest {

    @MockBean
    LaunchesService launchesService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testCalculateTotalLaunches() throws Exception {
        int actualTotalLaunches = 10;
        int expectedTotalLaunches = 10;

        Mockito.when(launchesService.totalLaunches()).thenReturn(actualTotalLaunches);
        mockMvc.perform(get("/launches/total"))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(expectedTotalLaunches)));
    }

    @Test
    public void testCalculateTotalSuccessfulLaunches() throws Exception {
        int actualTotalSuccessful = 100;
        int expectedTotalSuccessful = 100;

        Mockito.when(launchesService.successfulLaunches()).thenReturn(actualTotalSuccessful);
        mockMvc.perform(get("/launches/successful"))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(expectedTotalSuccessful)));
    }
}
