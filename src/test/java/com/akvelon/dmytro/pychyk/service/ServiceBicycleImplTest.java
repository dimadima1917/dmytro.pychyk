package com.akvelon.dmytro.pychyk.service;

import com.akvelon.dmytro.pychyk.dao.Dao;
import com.akvelon.dmytro.pychyk.domain.Bicycle;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ServiceBicycleImplTest {

    @Mock
    Dao<Bicycle> bicycleDao;

    @InjectMocks
    ServiceBicycleImpl bicycleService;

    private Bicycle bicycle;

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

        verify(bicycleDao).add(bicycle);
    }

    @Test
    public void addTest_bicycleNull_willWorkIncorrectly() throws Exception {

        long expected = -1;

        when(bicycleDao.add(null)).thenReturn((long) -1);

        long i = bicycleService.add(null);

        assertEquals(expected, i);

    }

    @Test
    public void updateTest_bicycleNull_willWorkIncorrectly() throws Exception {

        boolean expected = false;

        when(bicycleDao.update(null)).thenReturn(false);

        boolean result = bicycleService.update(null);

        assertEquals(expected, result);

    }

    @Test
    public void updateTest_bicycleNotNull_willWorkCorrectly() throws Exception {

        when(bicycleDao.update(bicycle)).thenReturn(true);

        boolean result = bicycleService.update(bicycle);

        assertEquals(true, result);

        verify(bicycleDao).update(bicycle);
    }

    @Test
    public void deleteTest_delete_existsInDataBase() {
        when(bicycleDao.searchById(bicycle.getProductId())).thenReturn(bicycle);

        when(bicycleDao.delete(bicycle.getProductId())).thenReturn(true);

        boolean delete = bicycleService.delete(bicycle.getProductId());

        boolean expected = true;

        assertEquals(expected, delete);

        verify(bicycleDao).delete(bicycle.getProductId());
    }

    @Test
    public void deleteTest_delete_notExistsInDataBase() {
        when(bicycleDao.searchById(bicycle.getProductId())).thenReturn(null);

        boolean delete = bicycleService.delete(bicycle.getProductId());

        boolean expected = false;

        assertEquals(expected, delete);
    }

    @Test
    public void searchByIdTest_ifExists_returnBicycle() {
        when(bicycleDao.searchById(bicycle.getProductId())).thenReturn(bicycleMap.get(bicycle.getProductId()));

        int idResult = bicycleService.searchById(bicycle.getProductId()).getProductId();

        assertEquals(bicycleMap.get(bicycle.getProductId()).getProductId(), idResult);

        verify(bicycleDao).searchById(bicycle.getProductId());
    }

    @Test
    public void searchByIdTest_ifNotExists_returnBicycle() {
        when(bicycleDao.searchById(bicycle.getProductId())).thenReturn(null);

        Bicycle idResult = bicycleService.searchById(bicycle.getProductId());

        assertEquals(null, idResult);

        verify(bicycleDao).searchById(bicycle.getProductId());
    }

    @Test
    public void searchBySting_ifExists_returnEmptyList() {
        when(bicycleDao.searchByString("")).thenReturn(new ArrayList<Bicycle>());

        int result = bicycleService.searchByString("").size();

        int expected = 0;

        assertEquals(expected, result);
    }
    @Test
    public void searchBySting_ifExists_returnNotEmptyList() {
        when(bicycleDao.searchByString("")).thenReturn(Arrays.asList(new Bicycle[10]));

        int result = bicycleService.searchByString("").size();

        assertTrue(result > 0);

        verify(bicycleDao).searchByString("");
    }

}
