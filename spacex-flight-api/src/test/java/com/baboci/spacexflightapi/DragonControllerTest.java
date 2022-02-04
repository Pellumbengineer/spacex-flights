package com.baboci.spacexflightapi;

import com.baboci.spacexflightapi.controller.DragonController;
import com.baboci.spacexflightapi.service.DragonService;
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
@WebMvcTest(DragonController.class)
public class DragonControllerTest {

    @MockBean
    DragonService dragonService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testCalculateTimeInSpace() throws Exception {
        int expectedTotal = 2;
        int actualTotal = 2;

        Mockito.when(dragonService.totalTimeInSpaceOfAllDragonFlights()).thenReturn(actualTotal);
        mockMvc.perform(get("/dragons/totalTime"))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(expectedTotal)));
    }
}

