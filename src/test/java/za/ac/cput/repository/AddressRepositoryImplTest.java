/* AddressRepositoryTest.java
 Test class for AddressRepository
 Author: Dominic Dave Przygonski (219206414)
 Date: 14 June 2022
*/
package za.ac.cput.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.CityFactory;
import za.ac.cput.factory.CountryFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddressRepositoryImplTest {

    private Address address;
    private City city;
    private Country country;
    @Autowired private IAddressRepository addressRepository;
    private Address.AddressID addressID;

    @BeforeEach
    void setUp() {
        this.country = CountryFactory.build("2055","South Africa");
        this.city = CityFactory.build("2055", "Cape Town",country);
        this.address = AddressFactory.createAddress("10","5","14","Johnson",7800,city);
        this.addressID = AddressFactory.buildID(this.address);


    }

    @AfterEach
    void tearDown(){
        this.addressRepository.delete(this.address);
    }

    @Test
    void save() {
        Address saved = this.addressRepository.save(this.address);
        System.out.println(saved);
        assertNotNull(saved);
        assertSame(this.address, saved);
    }

    @Test
    void read() {
        Address saved = this.addressRepository.save(this.address);
        Optional<Address> read = this.addressRepository.findById(this.addressID);
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertSame(saved, read.get())
        );
    }

    @Test
    void delete() {
        Address saved = this.addressRepository.save(this.address);
        this.addressRepository.delete(saved);
        List<Address> addressSet = this.addressRepository.findAll();
        assertEquals(0,addressSet.size());
    }

    @Test
    void getAll() {
        this.addressRepository.save(this.address);
        List<Address> addressSet = this.addressRepository.findAll();
        assertEquals(1,addressSet.size());
    }
}