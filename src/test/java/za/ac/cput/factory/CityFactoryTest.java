package za.ac.cput.factory;
/*
 CityFactoryTest.java
 Test for the City factory
 Author: Mogamad Githr Parker (220408025)
 Date: 18/06/2022
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;

import static org.junit.jupiter.api.Assertions.*;

class CityFactoryTest {
    Country country = CountryFactory.build("220408024", "South Africa");

    @Test
    void buildWithSuccess() {
        City city = CityFactory.build("220408025", "Cape Town", country);
        System.out.println(city);
        assertNotNull(city);
    }

    @Test
    void buildWithError() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> CityFactory.build(null, "", country));

        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        //assertTrue(exception.getMessage().contains("id"));
        assertEquals("Invalid value for param: id", exceptionMessage);
    }
}