package za.ac.cput.service;

import za.ac.cput.domain.City;
import za.ac.cput.repository.CityRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class CityServiceImpl implements CityService {
    private CityRepositoryImpl cityRepository;
    private static CityService CITY_SERVICE;

    private CityServiceImpl() {
        this.cityRepository = CityRepositoryImpl.getCityRepository();
    }

    public static CityService getCityService() {
        if (CITY_SERVICE == null)
            CITY_SERVICE = new CityServiceImpl();
        return CITY_SERVICE;
    }

    public City save(City city) {
        return this.cityRepository.save(city);
    }

    public Optional<City> read(String id) {
        return this.cityRepository.read(id);
    }

    public void delete(City city) {
        this.cityRepository.delete(city);
    }

    public List<City> readAll() {
        return this.cityRepository.readAll();
    }
}
