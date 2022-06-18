package za.ac.cput.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;
import za.ac.cput.factory.CityFactory;
import za.ac.cput.factory.CountryFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CityRepositoryImplTest {
    private Country country;
    private City city;
    private CityRepository cityRepository;
    //private Country SouthAfrica = CountryFactory.build("2121212222", "South Africa");


    @BeforeEach void setup() {
        this.country = CountryFactory.build("37269481", "South Africa");
        this.city = CityFactory.build("212121212", "Cape Town", country);
        this.cityRepository = CityRepositoryImpl.getCityRepository();
        City saved = this.cityRepository.save(this.city);
        assertSame(this.city, saved);
    }

    @AfterEach void tearDown() {
        this.cityRepository.delete(city);
        List<City> cities = this.cityRepository.readAll();
        assertEquals(0, cities.size());
    }

    @Test
    void read() {
        Optional<City> read = this.cityRepository.read(this.city.getId());
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertSame(this.city, read.get())
        );
    }

    @Test
    void readAll() {
        List<City> cities = this.cityRepository.readAll();
        assertEquals(1, cities.size());
    }
}