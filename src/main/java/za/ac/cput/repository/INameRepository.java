package za.ac.cput.repository;
import java.util.Optional;

/*
 * Name.java
 * entity for the Name
 * Author: Benelzane Kholani (218257465)
 * Date: 16 June 2022
 *
 */

public interface INameRepository<T, ID> {
    T save(T t);
    Optional<T> read(ID id);
    void delete(T t);
}
