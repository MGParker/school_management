/*
 * StudentControllerTest.java
 * Controller test for student controller
 * Rhegan Albert Fortuin 219273693
 * Date of last edit:2022/06/18
 */

package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Name;
import za.ac.cput.domain.Student;
import za.ac.cput.factory.NameFactory;
import za.ac.cput.factory.StudentFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StudentControllerTest {
    @LocalServerPort
    private int port;
    @Autowired
    private StudentController controller;
    @Autowired
    private TestRestTemplate restTemplate;
    private Student student;
    private Name name;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.name = NameFactory.getName("John", "Peter", "Doe");
        this.student = StudentFactory.createStudent("34ghr", "johdoe007@gmail.com", name);
        this.baseUrl = "http://localhost:" + this.port + "/school-management/employee";
    }

    @Test
    @Order(1)
    void save() {
        String url = baseUrl + "/save";
        System.out.println(url);
        ResponseEntity<Student> response = this.restTemplate.postForEntity(url, this.student, Student.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(2)
    void read() {
        String url = baseUrl + "/read/" + this.student.getStudentId();
        System.out.println(url);
        ResponseEntity<Student> response = this.restTemplate.getForEntity(url, Student.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(3)
    void delete() {
        String url = baseUrl + "delete/" + this.student.getStudentId();
        this.restTemplate.delete(url);
    }

    @Test
    @Order(4)
    void findAll() {
        String url = baseUrl + "/all";
        System.out.println(url);
        ResponseEntity<Student[]> response =
                this.restTemplate.getForEntity(url, Student[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 0)
        );
    }
}