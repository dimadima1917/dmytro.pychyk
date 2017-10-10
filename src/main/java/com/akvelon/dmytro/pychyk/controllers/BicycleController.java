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


    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    public List<Bicycle> showAllBicycle() {
        return bicycleService.selectAll();
    }


    @RequestMapping(value = "/search/{id}", method = RequestMethod.GET)
    public Bicycle searchById(@PathVariable("id") long id) {
        return bicycleService.searchById(id);
    }

    //request 5 most Popular Bicycle
    @RequestMapping(value = "/top5", method = RequestMethod.GET)
    public List<Bicycle> showMostPopularBicycle() {
        return bicycleService.selectMostPopular();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("id") int id) {
        return bicycleService.delete(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public long add(@RequestBody Bicycle bicycle) {
        return bicycleService.add(bicycle);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public boolean update(@RequestBody Bicycle bicycle) {
        return bicycleService.update(bicycle);
    }

    @RequestMapping(value = "/searchBySubstring/{string}", method = RequestMethod.GET)
    public List<Bicycle> searchByName(@PathVariable String string) {
        return bicycleService.searchByString(string);
    }
}
