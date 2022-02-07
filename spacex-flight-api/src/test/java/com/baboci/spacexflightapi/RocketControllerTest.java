package com.baboci.spacexflightapi;

import com.baboci.spacexflightapi.controller.RocketController;
import com.baboci.spacexflightapi.model.response.LoadResponse;
import com.baboci.spacexflightapi.model.response.SuccessRateResponse;
import com.baboci.spacexflightapi.service.RocketService;
import com.fasterxml.jackson.databind.ObjectMapper;
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
@WebMvcTest(RocketController.class)
public class RocketControllerTest {

    @MockBean
    RocketService rocketService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void testOverallSuccessRate() throws Exception {
        float actualSuccessRate = 50F;
        SuccessRateResponse successRateResponseExpected = new SuccessRateResponse();
        successRateResponseExpected.setRate_pct(50F);

        Mockito.when(rocketService.successRateOfAllRockets()).thenReturn(actualSuccessRate);

        mockMvc.perform(get("/rockets/successRate"))
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(successRateResponseExpected)));
    }

    @Test
    public void testLoadOfAllRockets() throws Exception {
        int actualSuccessRate = 10000;
        LoadResponse loadResponseExpected = new LoadResponse();
        loadResponseExpected.setKg(10000);

        Mockito.when(rocketService.totalLoadSentOfAllRockets()).thenReturn(actualSuccessRate);

        mockMvc.perform(get("/rockets/load"))
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(loadResponseExpected)));
    }

    @Test
    public void testLoadOfFalconRockets() throws Exception {
        int actualSuccessRate = 100000;
        LoadResponse loadResponseExpected = new LoadResponse();
        loadResponseExpected.setKg(100000);

        Mockito.when(rocketService.totalLoadSentOfFalconRockets()).thenReturn(actualSuccessRate);

        mockMvc.perform(get("/rockets/load/falcon"))
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(loadResponseExpected)));
    }

}
