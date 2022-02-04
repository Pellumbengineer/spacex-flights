package com.baboci.spacexflightapi;

import com.baboci.spacexflightapi.error.ControllerAdviceHandler;
import com.baboci.spacexflightapi.error.EmptyListException;
import com.baboci.spacexflightapi.service.DragonService;
import com.baboci.spacexflightapi.service.LaunchesService;
import com.baboci.spacexflightapi.service.RocketService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ComponentUnitTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void givenInScopeComponents_whenSearchingInApplicationContext_thenFindThem() {
        assertNotNull(applicationContext.getBean(RocketService.class));
        assertNotNull(applicationContext.getBean(LaunchesService.class));
        assertNotNull(applicationContext.getBean(DragonService.class));
        assertNotNull(applicationContext.getBean(EmptyListException.class));
        assertNotNull(applicationContext.getBean(ControllerAdviceHandler.class));
    }

    @Test
    public void givenRestTemplateBeanComponent_whenSearchingInApplicationContext_thenFindIt() {
        assertNotNull(applicationContext.getBean(RestTemplate.class));
    }
}