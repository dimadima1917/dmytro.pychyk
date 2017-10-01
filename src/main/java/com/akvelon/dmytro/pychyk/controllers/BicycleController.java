package com.akvelon.dmytro.pychyk.controllers;

import com.akvelon.dmytro.pychyk.domain.Bicycle;
import com.akvelon.dmytro.pychyk.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8090")
@RestController
public class BicycleController {


    @Autowired
    private Service<Bicycle> bicycleService;


    @RequestMapping(value = "/showAll",method = RequestMethod.GET)
    public List<Bicycle> showAllBicycle(){
        return bicycleService.selectAll();
    }


    @RequestMapping(value = "/search/{name}",method = RequestMethod.GET)
    public Bicycle searchByName(@PathVariable("name") String name){
        return bicycleService.searchByName(name);
    }

    //request 5 most Popular Bicycle
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Bicycle> showMostPopularBicycle(){
        return bicycleService.selectMostPopular();
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id){
        bicycleService.delete(id);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public long add(@RequestBody Bicycle bicycle){
        System.out.println(bicycle);
        return bicycleService.add(bicycle);


    }
}
