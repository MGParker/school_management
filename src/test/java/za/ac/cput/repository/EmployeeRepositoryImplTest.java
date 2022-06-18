/* EmployeeRepositoryImplTest.java
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
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Name;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.factory.NameFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeRepositoryImplTest {

    private Name name;
    private Employee employee;
    @Autowired
    private IEmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
        this.name = NameFactory.getName("Rick","Ricky","Rock");
        this.employee = EmployeeFactory.createEmployee("2055","219206414@mycput.ac.za",name);
    }

    @AfterEach
    void tearDown(){
        this.employeeRepository.delete(this.employee);
    }

    @Test
    void save() {
        Employee saved = this.employeeRepository.save(this.employee);
        System.out.println(saved);
        assertNotNull(saved);
        assertSame(this.employee, saved);
    }

    @Test
    void read() {
        Employee saved = this.employeeRepository.save(this.employee);
        Optional<Employee> read = this.employeeRepository.findById(employee.getStaffID());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertSame(saved, read.get())
        );
    }

    @Test
    void delete() {
        Employee saved = this.employeeRepository.save(this.employee);
        this.employeeRepository.delete(saved);
        List<Employee> employeeSet = this.employeeRepository.findAll();
        assertEquals(0,employeeSet.size());
    }

    @Test
    void getAll() {
        this.employeeRepository.save(this.employee);
        List<Employee> employeeSet = this.employeeRepository.findAll();
        assertEquals(1,employeeSet.size());
    }
}