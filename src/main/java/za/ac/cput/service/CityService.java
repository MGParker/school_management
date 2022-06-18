package za.ac.cput.service;
/*
 CityService.java

 Interface for the City service
 Author: Mogamad Githr Parker (220408025)
 Date: 18/06/2022
 */

/*
 Author: Kamaludien Sonday (218168128)
 */

import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;

import java.util.List;

public interface CityService extends IService<City, String> {
    List<City> readAll();
    void deleteById(String id);
    List<City> findCitiesByCountry(Country country);
}
