package com.akvelon.dmytro.pychyk.dao;

import java.util.List;

public interface Dao <T> {

    List<T> selectAll();

    List<T> selectMostPopular();

    long add(T object);

    void delete(int id);

    List<T> search();
}
