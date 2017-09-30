package com.akvelon.dmytro.pychyk.service;

import java.util.List;

public interface Service<T> {

    List<T> selectMostPopular();

    List<T> selectAll();

    long add(T object);

    void delete(int id);
}
