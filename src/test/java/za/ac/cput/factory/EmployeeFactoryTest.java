package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.EmployeeAddress;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {

    @Test public void buildWithSuccess(){
        Employee employee = EmployeeFactory.createEmployee("5","kwkq@gmail.com",name);
        System.out.println(employee);
        assertAll(
                ()-> assertNotNull(address)
        );
    }

    @Test public void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class, ()->
                EmployeeFactory.createEmployee("5","k",name));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("email"));
    }

}