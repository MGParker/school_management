package za.ac.cput.service;
/*
 CountryServiceImpl.java
 Author: Kamaludien Sonday (218168128)
 */
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;
import za.ac.cput.factory.CountryFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CountryServiceImplTest {
    private Country country = CountryFactory.build("220408024", "South Africa");

    private CountryServiceImpl countryService;
    @Test
    void save() {
        Country saved = this.countryService.save(this.country);
        System.out.println(saved);
        assertAll(
                () -> assertNotNull(saved),
                () -> assertEquals(this.country, saved)
        );
    }

    @Test
    void read() {
        Optional<Country> read = this.countryService.read(this.country.getCountryId());
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.country, read.get())
        );
    }

    @Test
    void delete() {
        this.countryService.delete(this.country);
        List<Country> cities = this.countryService.getAll();
        assertEquals(0, cities.size());
    }


    @Test
    void getAll() {
        this.countryService.save(this.country);
        List<Country> cities = this.countryService.getAll();
        assertEquals(1, cities.size());
    }
}