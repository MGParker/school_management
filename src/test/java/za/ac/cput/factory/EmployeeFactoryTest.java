package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.EmployeeAddress;
import za.ac.cput.domain.Name;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {

    Name name = NameFactory.getName("Jack", "Jill", "Johnson");

    @Test public void buildWithSuccess(){
        Employee employee = EmployeeFactory.createEmployee("5","username@domain.com",name);
        System.out.println(employee);
        assertAll(
                ()-> assertNotNull(employee)
        );
    }

    @Test public void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class, ()->
                EmployeeFactory.createEmployee("5","k",name));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("email"));
    }

}