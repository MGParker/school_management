package za.ac.cput.repository;

import za.ac.cput.domain.Country;

import java.util.List;
import java.util.Optional;

public interface ICountryRepository<T, ID> {
    T save(T t);
    Optional<T> read(ID id);
    void delete(T t);

    List<Country> getAll();
}
