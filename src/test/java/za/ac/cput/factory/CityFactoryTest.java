package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.City;

import static org.junit.jupiter.api.Assertions.*;

class CityFactoryTest {

    @Test
    void buildWithSuccess() {
        City city = CityFactory.build("", "", "");
        System.out.println(city);
        assertNotNull(city);
    }

    @Test
    void buildWithError() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> CityFactory.build(null, "", ""));

        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("Invalid value for param: id", exceptionMessage);
    }
}