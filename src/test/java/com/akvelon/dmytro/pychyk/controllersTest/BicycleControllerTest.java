package com.akvelon.dmytro.pychyk.controllersTest;

import com.akvelon.dmytro.pychyk.controllers.BicycleController;
import com.akvelon.dmytro.pychyk.domain.Bicycle;
import com.akvelon.dmytro.pychyk.service.Service;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class BicycleControllerTest {

    private List<Bicycle> bicycleList = new ArrayList<>();
    Bicycle bicycle1, bicycle2, bicycle3, bicycle4, bicycle5, bicycle6;
    private List<Bicycle> bicycle5MostPopularList = new ArrayList<>();

    Gson gson = new GsonBuilder().create();

    @Autowired
    MockMvc mockMvc;

    @Mock
    Service<Bicycle> bicycleService;

    @InjectMocks
    BicycleController bicycleController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(bicycleController)
                .build();
        bicycle1 = new Bicycle(1, "Bike1", "Bike1", "Bike1", 1, "Bike1", "Bike1");
        bicycle2 = new Bicycle(2, "Bike2", "Bike2", "Bike2", 2, "Bike2", "Bike2");
        bicycle3 = new Bicycle(3, "Bike3", "Bike3", "Bike3", 3, "Bike3", "Bike3");
        bicycle4 = new Bicycle(4, "Bike4", "Bike4", "Bike4", 4, "Bike4", "Bike4");
        bicycle5 = new Bicycle(3, "Bike3", "Bike3", "Bike3", 3, "Bike3", "Bike3");
        bicycle6 = new Bicycle(4, "Bike4", "Bike4", "Bike4", 4, "Bike4", "Bike4");

        bicycleList.add(bicycle1);
        bicycleList.add(bicycle2);
        bicycleList.add(bicycle3);
        bicycleList.add(bicycle4);
        bicycleList.add(bicycle5);
        bicycleList.add(bicycle6);


        bicycle5MostPopularList.add(bicycle1);
        bicycle5MostPopularList.add(bicycle2);
        bicycle5MostPopularList.add(bicycle3);
        bicycle5MostPopularList.add(bicycle4);
        bicycle5MostPopularList.add(bicycle5);
    }

    @Test
    public void showAllBicycleTest() throws Exception {
        when(bicycleService.selectAll()).thenReturn(bicycleList);
        String jsonRequest = gson.toJson(bicycleList);
        String jsonResponse = gson.toJson(bicycleList);
        mockMvc.perform(get("/showAll").content(jsonRequest).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonResponse));
    }

    @Test
    public void show5MostPopularTest() throws Exception {
        when(bicycleService.selectMostPopular()).thenReturn(bicycle5MostPopularList);
        String jsonRequest = gson.toJson(bicycle5MostPopularList);
        String jsonResponse = gson.toJson(bicycle5MostPopularList);
        mockMvc.perform(get("/top5").content(jsonRequest).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonResponse));
    }

    @Test
    public void addTest_notNull_willWorkCorrectly() throws Exception {
        when(bicycleService.add(bicycle1)).thenReturn((long) bicycle1.getProductId());
        String jsonRequest = gson.toJson(bicycle1);
        String jsonResponse = gson.toJson(bicycleService.add(bicycle1));//gson.toJson(bicycleService.add(bicycle1));

        mockMvc.perform(post("/create").content(jsonRequest).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json(jsonResponse));

    }

    @Test
    public void addTest_null_willWorkCorrectly() throws Exception {
        when(bicycleService.add(null)).thenReturn((long) -1);
        String jsonRequest = gson.toJson(bicycle1);
        String jsonResponse = gson.toJson(bicycleService.add(bicycle1));

        mockMvc.perform(post("/create").content(jsonRequest).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json(jsonResponse));
    }

    @Test
    public void delete() throws Exception {

        when(bicycleService.delete(bicycle1.getProductId())).thenReturn(true);


        mockMvc.perform(MockMvcRequestBuilders.delete("/delete/{productId}", bicycle1.getProductId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }


    @Test
    public void searchById_existsInDB_returnBicycle() throws Exception {
        when(bicycleService.searchById(bicycle1.getProductId())).thenReturn(bicycle1);

        String jsonResponse = gson.toJson(bicycleService.searchById(bicycle1.getProductId()));

        mockMvc.perform(get("/search/{id}", bicycle1.getProductId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json(jsonResponse));
    }
}
