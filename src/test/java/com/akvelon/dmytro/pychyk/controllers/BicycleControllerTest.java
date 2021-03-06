package com.akvelon.dmytro.pychyk.controllers;

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

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class BicycleControllerTest {

    private Bicycle bicycle;

    private List<Bicycle> bicycleList;

    private Gson gson = new GsonBuilder().create();

    @Autowired
    MockMvc mockMvc;

    @Mock
    Service<Bicycle> bicycleService;

    @InjectMocks
    BicycleController bicycleController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(bicycleController).build();
        bicycle = new Bicycle(1, "Bike1", "Bike1", "Bike1", 1, "Bike1", "Bike1");
        Bicycle[] arrayBicycles = {bicycle};
        bicycleList = Arrays.asList(arrayBicycles);
    }

    @Test
    public void showAllBicycleTest() throws Exception {
        when(bicycleService.selectAll()).thenReturn(bicycleList);
        String jsonRequest = gson.toJson(bicycleList);
        String jsonResponse = gson.toJson(bicycleList);
        mockMvc.perform(get("/showAll").content(jsonRequest).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonResponse));
        verify(bicycleService).selectAll();
    }

    @Test
    public void show5MostPopularTest() throws Exception {
        when(bicycleService.selectMostPopular()).thenReturn(bicycleList);
        String jsonRequest = gson.toJson(bicycleList);
        String jsonResponse = gson.toJson(bicycleList);
        mockMvc.perform(get("/top5").content(jsonRequest).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonResponse));
        verify(bicycleService).selectMostPopular();
    }

    @Test
    public void addTest_notNull_returnPositiveNumber() throws Exception {
        when(bicycleService.add(bicycle)).thenReturn((long) bicycle.getProductId());
        String jsonRequest = gson.toJson(bicycle);
        String jsonResponse = gson.toJson(bicycle.getProductId());

        mockMvc.perform(post("/create").content(jsonRequest).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json(jsonResponse));

        verify(bicycleService).add(bicycle);
    }

    @Test
    public void addTest_null_fail() throws Exception {
        String jsonRequest = gson.toJson(null);

        mockMvc.perform(post("/create").content(jsonRequest).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void delete() throws Exception {
        when(bicycleService.delete(bicycle.getProductId())).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.delete("/delete/{productId}", bicycle.getProductId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));

        verify(bicycleService).delete(bicycle.getProductId());
    }


    @Test
    public void searchById_existsInDB_returnBicycle() throws Exception {
        when(bicycleService.searchById(bicycle.getProductId())).thenReturn(bicycle);

        String jsonResponse = gson.toJson(bicycle);

        mockMvc.perform(get("/search/{id}", bicycle.getProductId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json(jsonResponse));

        verify(bicycleService).searchById(bicycle.getProductId());
    }

    @Test
    public void searchByString_existsInDB_returnBicycle() throws Exception {
        String substringRequest = "mou";

        when(bicycleService.searchByString(substringRequest)).thenReturn(bicycleList);

        String jsonResponse = gson.toJson(bicycleList);

        mockMvc.perform(get("/searchBySubstring/{string}", substringRequest).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json(jsonResponse));

        verify(bicycleService).searchByString(substringRequest);
    }

    @Test
    public void update() throws Exception {
        when(bicycleService.update(bicycle)).thenReturn(true);

        String jsonRequest = gson.toJson(bicycle);

        mockMvc.perform(post("/update").content(jsonRequest).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));

        verify(bicycleService).update(bicycle);
    }
}
