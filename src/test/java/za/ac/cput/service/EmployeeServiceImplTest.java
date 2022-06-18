/* EmployeeServiceImplTest.java
 Test class for EmployeeService
 Author: Dominic Dave Przygonski (219206414)
 Date: 14 June 2022
*/

package za.ac.cput.service;

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
class EmployeeServiceImplTest {

    private Name name;
    private Employee employee;

    @Autowired
    private IEmployeeService service;

    @BeforeEach
    void setUp() {
        this.name = NameFactory.getName("Rick","Ricky","Rock");
        this.employee = EmployeeFactory.createEmployee("2055","219206414@mycput.ac.za",name);
    }

    @AfterEach
    void tearDown(){
        this.service.delete(this.employee);
    }

    @Test
    void save() {
        Employee saved = this.service.save(this.employee);
        System.out.println(saved);
        assertNotNull(saved);
        assertSame(this.employee, saved);
    }

    @Test
    void read() {
        Employee saved = this.service.save(this.employee);
        Optional<Employee> read = this.service.read(employee.getStaffID());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertSame(saved, read.get())
        );
    }

    @Test
    void delete() {
        Employee saved = this.service.save(this.employee);
        this.service.delete(saved);
        List<Employee> employeeSet = this.service.getAll();
        assertEquals(0,employeeSet.size());
    }

    @Test
    void getAll() {
        this.service.save(this.employee);
        List<Employee> employeeSet = this.service.getAll();
        assertEquals(1,employeeSet.size());
    }
}