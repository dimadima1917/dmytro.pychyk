package com.akvelon.dmytro.pychyk;

import com.akvelon.dmytro.pychyk.dao.Dao;
import com.akvelon.dmytro.pychyk.domain.Bicycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    @Autowired
    public static Dao<Bicycle> bicycleDao;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
        System.out.println(bicycleDao.searchByName("Mountain-100 Black, 38"));
    }
}
