package za.ac.cput.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.CityFactory;
import za.ac.cput.factory.CountryFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AddressServiceImplTest {

    private Address address;
    private Address.AddressID addressID;
    private City city;
    private Country country;
    private IAddressService service;

    @BeforeEach
    void setUp() {
        this.country = CountryFactory.build("2055","South Africa");
        this.city = CityFactory.build("2055", "Cape Town",country);
        this.address = AddressFactory.createAddress("10","5","14","Johnson",7800,city);
        this.addressID = AddressFactory.buildID(this.address);
        this.service = AddressServiceImpl.getService();
    }

    @AfterEach
    void tearDown() {
        this.service.delete(address);
    }

    @Test
    void save() {
        Address saved = this.service.save(this.address);
        System.out.println(saved);
        assertNotNull(saved);
        assertSame(this.address, saved);
    }

    @Test
    void read() {
        Address saved = this.service.save(this.address);
        Optional<Address> read = this.service.read(this.addressID);
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertSame(saved, read.get())
        );
    }

    @Test
    void delete() {
        Address saved = this.service.save(this.address);
        this.service.delete(saved);
        List<Address> addressSet = this.service.getAll();
        assertEquals(0,addressSet.size());
    }

    @Test
    void getAll() {
        this.service.save(this.address);
        List<Address> addressSet = this.service.getAll();
        assertEquals(1,addressSet.size());
    }
}