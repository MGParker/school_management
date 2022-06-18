/* EmployeeAddressAPI.java
   API for EmployeeAddress controller
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
import za.ac.cput.domain.EmployeeAddress;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.CityFactory;
import za.ac.cput.factory.CountryFactory;
import za.ac.cput.factory.EmployeeAddressFactory;
import za.ac.cput.service.CityService;
import za.ac.cput.service.IAddressService;
import za.ac.cput.service.IEmployeeAddressService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeeAddressAPITest {

    @Autowired
    private IAddressService addressService;
    @Autowired private IEmployeeAddressService employeeAddressService;

    @Autowired private EmployeeAddressAPI api;

    private Country country= CountryFactory.build("2055","South Africa");
    private City city = CityFactory.build("2055", "Cape Town",country);
    private Address address = AddressFactory.createAddress("10","5","14","Johnson",7800,city);
    private Address.AddressID addressID= AddressFactory.buildID(address);
    private EmployeeAddress employeeAddress = EmployeeAddressFactory.createEmployeeAddress("2055",address);
    private EmployeeAddress.EmployeeAddressID employeeAddressID = EmployeeAddressFactory.buildID(employeeAddress);

    @Test
    void save() {
        EmployeeAddress saved = this.api.save(this.employeeAddress);
    }

    @Test
    void read() {
        Optional<EmployeeAddress> saved = this.api.read(this.employeeAddressID);
        assertNotNull(saved);
    }

    @Test
    void delete() {
        this.api.delete(this.employeeAddress);
        assertEquals(0, this.api.getAll().size());
    }

    @Test
    void getAll() {
        Optional<EmployeeAddress> saved = this.api.read(this.employeeAddressID);
        assertEquals(1, this.api.getAll().size());
    }
}