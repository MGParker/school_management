package za.ac.cput.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeAddressControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private EmployeeAddressController employeeAddressController;
    @Autowired
    private TestRestTemplate restTemplate;

    private EmployeeAddress employeeAddress;
    private Address address;
    private String baseUrl;
    private Country country;
    private City city;
    private EmployeeAddress.EmployeeAddressID employeeAddressID;

    @BeforeEach
    void setUp() {
        assertNotNull(employeeAddressController);
        this.country = CountryFactory.build("2055","South Africa");
        this.city = CityFactory.build("2055", "Cape Town",country);
        this.address = AddressFactory.createAddress("test-unitNum", "test-complexNum","test-streetNum","test-streetName",
                7800, city);
        this.employeeAddress = EmployeeAddressFactory.createEmployeeAddress("2055",address);
        this.employeeAddressID = EmployeeAddressFactory.buildID(employeeAddress);

        this.baseUrl = "http://localhost:"+ this.port + "/schoolManagement/employeeAddress/";
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<EmployeeAddress> response = this.restTemplate.postForEntity(url, this.employeeAddress, EmployeeAddress.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    void read() {
        String url = baseUrl+"read/" + this.employeeAddressID;
        System.out.println(url);
        ResponseEntity<EmployeeAddress> response = this.restTemplate.getForEntity(url, EmployeeAddress.class);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    void getAll() {
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<EmployeeAddress[]> response = this.restTemplate.getForEntity(url, EmployeeAddress[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertTrue(response.getBody().length == 0)
        );
    }

    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.employeeAddressID;
        this.restTemplate.delete(url);
    }
}