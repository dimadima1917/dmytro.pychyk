package com.akvelon.dmytro.pychyk.service;

import java.util.List;

public interface Service<T> {
    List<T> selectMostPopular();

    long add(T object);

    void delete();
}
