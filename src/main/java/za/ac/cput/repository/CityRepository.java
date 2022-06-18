package za.ac.cput.repository;

import za.ac.cput.domain.City;

import java.util.List;

public interface CityRepository extends IRepository<City, String> {
    List<City> readAll();
}
