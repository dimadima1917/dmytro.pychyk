package akvelon.com.controllers;

import akvelon.com.domain.Bicycle;
import akvelon.com.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class TestController {

    @Autowired
    private Service<Bicycle> bicycleService;

    @RequestMapping("/hello")
    public List<Bicycle> showMostPopularBicycle(){
        return bicycleService.selectMostPopular();
    }
}
