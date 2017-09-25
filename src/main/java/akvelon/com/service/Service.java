package akvelon.com.service;

import java.util.List;

public interface Service<T> {
    List<T> selectMostPopular();

    void add(T object);

    void delete();
}
