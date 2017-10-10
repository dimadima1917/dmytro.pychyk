package com.akvelon.dmytro.pychyk.dao;

import com.akvelon.dmytro.pychyk.domain.Bicycle;

import java.util.List;

public interface Dao <T> {

    List<T> selectAll();

    List<T> selectMostPopular();

    long add(T object);

    boolean delete(long id);

    T searchById(long id);

    boolean update(Bicycle bicycle);

    List<T> searchByString(String substring);

}
