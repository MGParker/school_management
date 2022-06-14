package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;

import static org.junit.jupiter.api.Assertions.*;

class AddressFactoryTest {

    @Test public void buildWithSuccess(){
        Address address = AddressFactory.createAddress("5","5","5","Johnson","7800", CapeTown);
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
        assertTrue(exception.getMessage().contains("unitNumber"));
    }

}