package za.ac.cput.service;

import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;

import java.util.List;

public interface CityService extends IService<City, String> {
    List<City> readAll();
    void deleteById(String id);
    List<City> findCitiesByCountry(Country country);
}
