package com.akvelon.dmytro.pychyk.controllers;

import com.akvelon.dmytro.pychyk.domain.Bicycle;
import com.akvelon.dmytro.pychyk.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8090")
@RestController
public class BicycleController {


    @Autowired
    private Service<Bicycle> bicycleService;


    //request 5 most Popular Bicycle
    @RequestMapping(value = "/show5MostPopular",method = RequestMethod.GET)
    public List<Bicycle> showMostPopularBicycle(){
        return bicycleService.selectMostPopular();
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public long add(Bicycle bicycle){
        return 0;
    }
}
