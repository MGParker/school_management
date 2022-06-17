package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Name;
import za.ac.cput.domain.Student;

import static org.junit.jupiter.api.Assertions.*;

class StudentFactoryTest {
    //Passed test
    @Test
    public void buildWithSuccess(){
        Name name = NameFactory.getName("Rhegan","Albert","Fortuin");
        Student student = StudentFactory.createStudent("RAF000819", "bobtheslayer@yourmom.com", name);
        System.out.println(student);
        assertNotNull(student);
    }

    //failed id test
    @Test
    public void buildWithFailureId(){
        Name name = NameFactory.getName("Rhegan","Albert","Fortuin");
        Exception err = assertThrows(IllegalArgumentException.class, ()->StudentFactory.createStudent(null, "bobtheslayer@yourmom.com", name));
        System.out.println(err);
        assertSame("Student Id required", err.getMessage());
    }

    //failed email test
    @Test
    public void buildWithFailureEmail(){
        Name name = NameFactory.getName("Rhegan","Albert","Fortuin");
        Exception err = assertThrows(IllegalArgumentException.class, ()->StudentFactory.createStudent("Rhegan", null, name));
        System.out.println(err);
        assertSame("Student email required", err.getMessage());
    }

    //failed name test
    @Test
    public void buildWithFailureName(){
        Name name = NameFactory.getName("Rhegan","Albert","Fortuin");
        Exception err = assertThrows(IllegalArgumentException.class, ()->StudentFactory.createStudent("Rhegan", "bobtheslayer@yourmom.com", null));
        System.out.println(err);
        assertSame("Student name required", err.getMessage());
    }
}