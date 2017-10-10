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
        long addTrue = -1;

        if (bicycle != null) {
            addTrue = bicycleDao.add(bicycle);
        } else {
            return addTrue;
        }
        return addTrue;
    }

    @Override
    public boolean delete(long id) {
        if (bicycleDao.searchById(id) != null) {
            return bicycleDao.delete(id);
        } else {
            return false;
        }
    }

    @Override
    public Bicycle searchById(long id) {
        return bicycleDao.searchById(id);
    }

    @Override
    public boolean update(Bicycle bicycle) {
        if (bicycle != null) {
            return bicycleDao.update(bicycle);
        } else {
            return false;
        }
    }

    @Override
    public List<Bicycle> searchByString(String substring) {
        return bicycleDao.searchByString(substring);
    }
}
