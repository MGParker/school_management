/* EmployeeAddressRepositoryImplTest.java
 Test class for AddressController
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
import za.ac.cput.domain.EmployeeAddress;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.CityFactory;
import za.ac.cput.factory.CountryFactory;
import za.ac.cput.factory.EmployeeAddressFactory;

import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeAddressRepositoryImplTest {

    private Address address;
    private City city;
    private Country country;
    private EmployeeAddress employeeAddress;
    @Autowired
    private IEmployeeAddressRepository employeeAddressRepository;
    private EmployeeAddress.EmployeeAddressID employeeAddressID;

    @BeforeEach
    void setUp() {
        this.country = CountryFactory.build("2055","South Africa");
        this.city = CityFactory.build("2055", "Cape Town",country);
        this.address = AddressFactory.createAddress("10","5","14","Johnson",7800,city);
        this.employeeAddress = EmployeeAddressFactory.createEmployeeAddress("2055",address);
        this.employeeAddressID = EmployeeAddressFactory.buildID(this.employeeAddress);
    }

    @AfterEach
    void tearDown(){
        this.employeeAddressRepository.delete(this.employeeAddress);
    }

    @Test
    void save() {
        EmployeeAddress saved = this.employeeAddressRepository.save(this.employeeAddress);
        System.out.println(saved);
        assertNotNull(saved);
        assertSame(this.employeeAddress, saved);
    }

    @Test
    void read() {
        EmployeeAddress saved = this.employeeAddressRepository.save(this.employeeAddress);
        Optional<EmployeeAddress> read = this.employeeAddressRepository.findById(this.employeeAddressID);
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertSame(saved, read.get())
        );
    }

    @Test
    void delete() {
        EmployeeAddress saved = this.employeeAddressRepository.save(this.employeeAddress);
        this.employeeAddressRepository.delete(saved);
        List<EmployeeAddress> employeeAddressSet = this.employeeAddressRepository.findAll();
        assertEquals(0,employeeAddressSet.size());
    }

    @Test
    void getAll() {
        this.employeeAddressRepository.save(this.employeeAddress);
        List<EmployeeAddress> employeeAddressSet = this.employeeAddressRepository.findAll();
        assertEquals(1,employeeAddressSet.size());
    }
}