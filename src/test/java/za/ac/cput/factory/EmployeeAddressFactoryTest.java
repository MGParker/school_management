package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;
import za.ac.cput.domain.EmployeeAddress;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeAddressFactoryTest {

    Country SouthAfrica = CountryFactory.build("2055","South Africa");
    City CapeTown = CityFactory.build("2055", "Cape Town", SouthAfrica);
    Address address = AddressFactory.createAddress("5","20", "14", "Johnson", 7800, CapeTown);

    @Test public void buildWithSuccess(){
        EmployeeAddress employeeAddress = EmployeeAddressFactory.createEmployeeAddress("555",address);
        System.out.println(employeeAddress);
        assertAll(
                ()-> assertNotNull(employeeAddress)
        );
    }

    @Test public void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class, ()->
                EmployeeAddressFactory.createEmployeeAddress("", address));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("staffID"));
    }

}