package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.City;
import za.ac.cput.repository.CityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City save(City city) {
        return this.cityRepository.save(city);
    }

    public Optional<City> read(String id) {
        return this.cityRepository.findById(id);
    }

    public void delete(City city) {
        this.cityRepository.delete(city);
    }

    public List<City> readAll() {
        return this.cityRepository.findAll();
    }

    public void deleteById(String id) {
        Optional<City> city = read(id);
        if (city.isPresent())
            delete(city.get());
    }
}
