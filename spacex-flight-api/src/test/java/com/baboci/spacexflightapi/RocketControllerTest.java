package com.baboci.spacexflightapi;

import com.baboci.spacexflightapi.controller.RocketController;
import com.baboci.spacexflightapi.service.RocketService;
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

    @Test
    public void testOverallSuccessRate() throws Exception {
        float actualSuccessRate = 50F;
        float expectedSuccessRate = 50F;

        Mockito.when(rocketService.successRateOfAllRockets()).thenReturn(actualSuccessRate);

        mockMvc.perform(get("/rockets/successRate"))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(expectedSuccessRate)));
    }

}
