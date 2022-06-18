package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;

import static org.junit.jupiter.api.Assertions.*;

class CityFactoryTest {
    Country SouthAfrica = CountryFactory.build("123456789", "South Africa");

    @Test
    void buildWithSuccess() {
        City city = CityFactory.build("21223933", "Cape Town", SouthAfrica);
        System.out.println(city);
        assertNotNull(city);
    }

    @Test
    void buildWithError() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> CityFactory.build(null, "", SouthAfrica));

        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        //assertTrue(exception.getMessage().contains("id"));
        assertEquals("Invalid value for param: id", exceptionMessage);
    }
}