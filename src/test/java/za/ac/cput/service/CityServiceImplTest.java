package za.ac.cput.service;

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

class CityServiceImplTest {
    private Country country;
    private City city;
    private CityService cityService;

    @BeforeEach
    //The setUp tests the save functionality
    void setUp() {
        this.country = CountryFactory.build("828151651", "South Africa");
        this.city = CityFactory.build("526517865", "Cape Town", country);
        this.cityService = CityServiceImpl.getCityService();
        City saved = this.cityService.save(this.city);
        assertSame(this.city, saved);
    }

    @AfterEach
    //The tearDown tests the delete functionality
    void tearDown() {
        this.cityService.delete(this.city);
        List<City> cities = this.cityService.readAll();
        assertEquals(0, cities.size());
    }

    /*
    @Test
    void save() {
        City save = this.cityService.save(this.city);
        System.out.println(save);
        assertNotNull(save);
        assertSame(this.city, save);
    }*/

    @Test
    void read() {
        Optional<City> read = this.cityService.read(this.city.getId());
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.city, read.get())
        );
    }

    /*
    @Test
    void delete() {
        City save = this.cityService.save(this.city);
        this.cityService.delete(save);
        List<City> cities = this.cityService.readAll();
        assertEquals(0, cities.size());
    }*/

    @Test
    void readAll() {
        this.cityService.save(this.city);
        List<City> cities = this.cityService.readAll();
        assertEquals(1, cities.size());
    }
}