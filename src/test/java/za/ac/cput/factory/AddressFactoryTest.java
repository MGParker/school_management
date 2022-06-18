/* AddressFactoryTest.java
 Test class for AddressFactory
 Author: Dominic Dave Przygonski (219206414)
 Date: 14 June 2022
*/
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;

import static org.junit.jupiter.api.Assertions.*;

class AddressFactoryTest {

    Country SouthAfrica = CountryFactory.build("2055","South Africa");
    City CapeTown = CityFactory.build("2055", "Cape Town", SouthAfrica);

    @Test public void buildWithSuccess(){
        Address address = AddressFactory.createAddress("5","5","5","Johnson",7800, CapeTown);
        System.out.println(address);
        assertAll(
                ()-> assertNotNull(address),
                ()->assertNotNull(address.getComplexNumber())
        );
    }

    @Test public void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class, ()->
                AddressFactory.createAddress("", "", "","",0, CapeTown));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("streetNumber"));
    }

}