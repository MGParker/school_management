package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Student;

import static org.junit.jupiter.api.Assertions.*;

class StudentFactoryTest {
    //failed test
    @Test
    public void buildWithSuccess(){
        Student student = StudentFactory.createStudent("100", "bobtheslayer@yourmom.com", "Bob Ross");
        System.out.println(student);
        assertNotNull(student);
    }

    //passed test
    @Test
    public void buildWithFailure(){
        Exception err = assertThrows(IllegalArgumentException.class, ()->StudentFactory.createStudent(null, "bobtheslayer@yourmom.com", "Bob Ross");
        System.out.println(err);
        assertSame("Staff Id required", err.getMessage());
    }
}