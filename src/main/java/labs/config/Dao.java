package labs.config;

public interface Dao<T> {

    T save(T t);
    T findById(Object o);
    void update(T t);
    void delete(Object o);

}
