package akvelon.com.dao;

import java.util.List;

public interface Dao <T> {

    List<T> selectMostPopular();

    long add(T object);

    void delete();
}
