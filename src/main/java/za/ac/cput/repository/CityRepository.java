package za.ac.cput.repository;
/*
 CityRepository.java

 Interface for the City repository
 Author: Mogamad Githr Parker (220408025)
 Date: 18/06/2022

 Author: Kamaludien Sonday (218168128)

 */

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
