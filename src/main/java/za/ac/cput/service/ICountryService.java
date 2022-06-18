package za.ac.cput.service;
/*
 ICountryService.java
 Author: Kamaludien Sonday (218168128)
 */
import java.util.Optional;

public interface ICountryService<T, ID> {
    T save(T t);
    Optional<T> read(ID id);
    void delete(T t);

    void deleteById(ID id);
}
