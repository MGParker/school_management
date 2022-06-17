package za.ac.cput.repository;

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
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AddressRepositoryImplTest {

    private Address address;
    private City city;
    private Country country;
    private AddressRepositoryImpl addressRepository;
    private Address.AddressID addressID;

    @BeforeEach
    void setUp() {
        this.country = CountryFactory.build("2055","South Africa");
        this.city = CityFactory.build("2055", "Cape Town",country);
        this.address = AddressFactory.createAddress("10","5","14","Johnson",7800,city);
        this.addressID = AddressFactory.buildID(this.address);
        this.addressRepository = AddressRepositoryImpl.getRepository();

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
        Optional<Address> read = this.addressRepository.read(this.addressID);
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertSame(saved, read.get())
        );
    }

    @Test
    void delete() {
        Address saved = this.addressRepository.save(this.address);
        this.addressRepository.delete(saved);
        List<Address> addressSet = this.addressRepository.getAll();
        assertEquals(0,addressSet.size());
    }

    @Test
    void getAll() {
        this.addressRepository.save(this.address);
        List<Address> addressSet = this.addressRepository.getAll();
        assertEquals(1,addressSet.size());
    }
}