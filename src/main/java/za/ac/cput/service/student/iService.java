/*
 * iService.java
 * iService class with @service annotation and generic
 * Rhegan Albert Fortuin 219273693
 * Date of last edit:2022/06/18
 */

package za.ac.cput.service.student;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface iService<T, Id> {
    T save(T t);

    Optional<T> read(Id id);

    void delete(T t);
}
