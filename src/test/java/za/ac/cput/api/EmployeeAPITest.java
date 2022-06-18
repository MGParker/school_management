package za.ac.cput.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import za.ac.cput.service.IAddressService;
import za.ac.cput.service.IEmployeeAddressService;
import za.ac.cput.service.IEmployeeService;
import za.ac.cput.service.INameService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeeAPITest {

    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private INameService nameService;
    @Autowired private EmployeeAPI api;

   private Name name = NameFactory.getName("John", "Rick", "Dave");
   private Employee employee = EmployeeFactory.createEmployee("2055", "210483@gmail.com", name);

    @Test
    void save() {
        Employee saved = this.api.save(this.employee);
    }

    @Test
    void read() {
        Optional<Employee> saved = this.api.read(this.employee.getStaffID());
        assertNotNull(saved);
    }

    @Test
    void delete() {
        this.api.delete(this.employee);
        assertEquals(0, this.api.getAll().size());
    }

    @Test
    void getAll() {
        Optional<Employee> saved = this.api.read(this.employee.getStaffID());
        assertEquals(1, this.api.getAll().size());
    }
}