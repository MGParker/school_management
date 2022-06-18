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
class EmployeeControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private EmployeeController employeeController;
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseUrl;
    private Employee employee;
    private Name name;

    @BeforeEach
    void setUp() {
        assertNotNull(employeeController);
        this.name = NameFactory.getName("Joe","Jeff", "Dave");
        this.employee = EmployeeFactory.createEmployee("2055", "201284@gmail.com", name);

        this.baseUrl = "http://localhost:"+ this.port + "/schoolManagement/employee/";
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Employee> response = this.restTemplate.postForEntity(url, this.employee, Employee.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    void read() {
        String url = baseUrl+"read/" + this.employee.getStaffID();
        System.out.println(url);
        ResponseEntity<Employee> response = this.restTemplate.getForEntity(url, Employee.class);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    void getAll() {
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<Employee[]> response = this.restTemplate.getForEntity(url, Employee[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertTrue(response.getBody().length == 0)
        );
    }

    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.employee.getStaffID();
        this.restTemplate.delete(url);
    }
}