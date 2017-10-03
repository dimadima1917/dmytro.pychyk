package com.akvelon.dmytro.pychyk.controllersTest;

import com.akvelon.dmytro.pychyk.controllers.BicycleController;
import com.akvelon.dmytro.pychyk.domain.Bicycle;
import com.akvelon.dmytro.pychyk.service.Service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BicycleControllerTest {

    @Mock
    Service<Bicycle> bicycleService;

    @InjectMocks
    BicycleController bicycleController;


    @Test
    public void showHelloWorldTest() throws Exception {

    }
}
