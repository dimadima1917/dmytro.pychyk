package akvelon.com.service;

import akvelon.com.dao.Dao;
import akvelon.com.domain.Bicycle;
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
    public void add(Bicycle object) {

    }

    @Override
    public void delete() {

    }
}
