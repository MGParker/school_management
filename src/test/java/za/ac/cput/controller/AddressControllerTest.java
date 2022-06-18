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
import za.ac.cput.domain.Address;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.CityFactory;
import za.ac.cput.factory.CountryFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AddressControllerTest {

    @LocalServerPort
    private int port;

    @Autowired private AddressController addressController;
    @Autowired private TestRestTemplate restTemplate;

    private Address address;
    private Address.AddressID addressID;
    private Country country;
    private City city;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        assertNotNull(addressController);
        this.country = CountryFactory.build("2055","South Africa");
        this.city = CityFactory.build("2055", "Cape Town",country);
        this.address = AddressFactory.createAddress("test-unitNum", "test-complexNum","test-streetNum","test-streetName",
                7800, city);
        this.addressID = AddressFactory.buildID(address);

        this.baseUrl = "http://localhost:"+ this.port + "/schoolManagement/address/";
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Address> response = this.restTemplate.postForEntity(url, this.address, Address.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    void read() {
        String url = baseUrl+"read/" + this.addressID;
        System.out.println(url);
        ResponseEntity<Address> response = this.restTemplate.getForEntity(url, Address.class);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    void getAll() {
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<Address[]> response = this.restTemplate.getForEntity(url, Address[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertTrue(response.getBody().length == 0)
        );
    }

    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.addressID;
        this.restTemplate.delete(url);
    }


}