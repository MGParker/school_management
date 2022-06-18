package za.ac.cput.repository;

import za.ac.cput.domain.City;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CityRepositoryImpl implements CityRepository {
    private List<City> cities;
    private static CityRepositoryImpl CITY_REPOSITORY;

    private CityRepositoryImpl() {
        this.cities = new ArrayList<>();
    }

    public static CityRepositoryImpl getCityRepository() {
        if (CITY_REPOSITORY == null)
            CITY_REPOSITORY = new CityRepositoryImpl();
        return CITY_REPOSITORY;
    }

    public City save(City city) {
        Optional<City> read = read(city.getId());
        if (read.isPresent())
            delete(city);
        this.cities.add(city);
        return city;
    }

    public Optional<City> read(String id) {
        return this.cities.stream().filter(g -> g.getId().equalsIgnoreCase(id)).findFirst();
    }

    public void delete(City city) {
        this.cities.remove(city);
    }

    public List<City> readAll() {
        return this.cities;
    }
}
