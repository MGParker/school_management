/* AddressAPITest.java
 Controller for address entity
 Author: Dominic Dave Przygonski (219206414)
 Date: 14 June 2022
*/
package za.ac.cput.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.CityFactory;
import za.ac.cput.factory.CountryFactory;
import za.ac.cput.service.CityService;
import za.ac.cput.service.IAddressService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class AddressAPITest {

    @Autowired private IAddressService addressService;
    @Autowired private CityService cityService;

    @Autowired private AddressAPI api;

    private Country country= CountryFactory.build("2055","South Africa");
    private City city = CityFactory.build("2055", "Cape Town",country);
    private Address address = AddressFactory.createAddress("10","5","14","Johnson",7800,city);
    private Address.AddressID addressID= AddressFactory.buildID(address);

    @Test
    void save() {
        Address saved = this.api.save(this.address);
    }

    @Test
    void read() {
        Optional<Address> saved = this.api.read(this.addressID);
        assertNotNull(saved);
    }

    @Test
    void delete() {
        this.api.delete(this.address);
        assertEquals(0, this.api.getAll().size());
    }

    @Test
    void getAll() {
        Optional<Address> saved = this.api.read(this.addressID);
        assertEquals(1, this.api.getAll().size());
    }
}