package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import za.ac.cput.factory.StudentFactory;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class iStudentRepositoryTest {

    @Autowired
    private iStudentRepository iStudentRepository;

    @Test
    public void saveStudent(){

    }
}