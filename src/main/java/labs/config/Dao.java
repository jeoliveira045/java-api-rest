package labs.config;

import java.util.List;

public interface Dao<T> {

    T save(T t);
    T findById(Object o);
    void update(T t);
    void delete(Object o);

    List<T> findAll();

}
