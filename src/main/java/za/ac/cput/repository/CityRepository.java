package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, String> {
    //Question 7
    List<City> findCitiesByCountry(Country country);
}
