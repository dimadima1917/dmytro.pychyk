package com.akvelon.dmytro.pychyk.service;

import com.akvelon.dmytro.pychyk.dao.Dao;
import com.akvelon.dmytro.pychyk.domain.Bicycle;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceBicycleImpl implements Service<Bicycle> {

    @Autowired
    Dao<Bicycle> bicycleDao;

    @Override
    public List<Bicycle> selectMostPopular() {
        return bicycleDao.selectMostPopular();
    }

    @Override
    public List<Bicycle> selectAll() {
        return bicycleDao.selectAll();
    }

    @Override
    public long add(Bicycle bicycle) {
        return bicycleDao.add(bicycle);
    }

    @Override
    public void delete() {

    }
}
