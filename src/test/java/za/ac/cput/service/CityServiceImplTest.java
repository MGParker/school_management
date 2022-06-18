package za.ac.cput.service;
/*
 CityServiceImplTest.java
 Test for the City service implementation
 Author: Mogamad Githr Parker (220408025)
 Date: 18/06/2022
 */

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;
import za.ac.cput.factory.CityFactory;
import za.ac.cput.factory.CountryFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CityServiceImplTest {
    private Country country = CountryFactory.build("220408024", "South Africa");
    private City city = CityFactory.build("220408025", "Cape Town", country);
    @Autowired
    private CityService cityService;

    @Test
    @Order(1)
    void save() {
        City saved = this.cityService.save(this.city);
        System.out.println(saved);
        assertAll(
                () -> assertNotNull(saved),
                () -> assertEquals(this.city, saved)
        );
    }

    @Test
    @Order(2)
    void read() {
        Optional<City> read = this.cityService.read(this.city.getId());
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.city, read.get())
        );
    }

    @Test
    @Order(4)
    void delete() {
        this.cityService.delete(this.city);
        List<City> cities = this.cityService.readAll();
        assertEquals(0, cities.size());
    }

    @Test
    @Order(3)
    void readAll() {
        this.cityService.save(this.city);
        List<City> cities = this.cityService.readAll();
        assertEquals(1, cities.size());
    }
}