package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Country;

import static org.junit.jupiter.api.Assertions.*;

class CountryFactoryTest {
    @Test public void build(){
        Country country = CountryFactory.build("12265", "South Africa");
        assertNotNull(country);
    }

    @Test public void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> CountryFactory.build(null, "South Africa"));

        String exceptionMessage = exception.getMessage();
        assertSame("invalid name", exceptionMessage);
    }

    @Test public void buildWithSuccess(){
        Country country = CountryFactory.build("123", "South Africa");
        assertNotNull(country);
    }

}