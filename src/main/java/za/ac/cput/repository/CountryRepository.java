package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

//    T save(T t);
//    Optional<T> read(ID id);
//    void delete(T t);

//    List<Country> getAll();
}
