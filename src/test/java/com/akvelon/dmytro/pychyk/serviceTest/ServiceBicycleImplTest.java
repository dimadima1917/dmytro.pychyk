package com.akvelon.dmytro.pychyk.serviceTest;

import com.akvelon.dmytro.pychyk.dao.Dao;
import com.akvelon.dmytro.pychyk.domain.Bicycle;
import com.akvelon.dmytro.pychyk.service.ServiceBicycleImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ServiceBicycleImplTest {

    @Mock
    Dao<Bicycle> bicycleDao;

    @InjectMocks
    ServiceBicycleImpl bicycleService;

    Bicycle bicycle;

    Map<Integer, Bicycle> bicycleMap = new LinkedHashMap<>();

    @Before
    public void initialize() {
        bicycle = new Bicycle(1, "sdasds", "sdsdasd", "sdasdsda", 3, "sdsad", "sdasdasd");
        bicycleMap.put(bicycle.getProductId(), bicycle);
    }

    @Test
    public void addTest_bicycleNotNull_willWorkCorrectly() throws Exception {

        when(bicycleDao.add(bicycle)).thenReturn((long) bicycle.getProductId());

        long i = bicycleService.add(bicycle);

        assertEquals(bicycle.getProductId(), i);

    }

    @Test
    public void addTest_bicycleNull_willWorkIncorrectly() throws Exception {

        long expected = -1;

        when(bicycleDao.add(null)).thenReturn((long) -1);

        long i = bicycleService.add(null);

        assertEquals(expected, i);
    }

    @Test
    public void deleteTest() {
        bicycleService.delete(bicycle.getProductId());
        verify(bicycleDao).delete(bicycle.getProductId());
    }

    @Test
    public void searchByIdTest() {
        when(bicycleDao.searchById(bicycle.getProductId())).thenReturn(bicycleMap.get(bicycle.getProductId()));

        int idResult = bicycleService.searchById(bicycle.getProductId()).getProductId();

        assertEquals(bicycleMap.get(bicycle.getProductId()).getProductId(), idResult);
    }
}
