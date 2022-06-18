/*
 * iStudentRepository.java
 * test class for student repository interface
 * Rhegan Albert Fortuin 219273693
 * Date of last edit:2022/06/18
 */

package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class iStudentRepositoryTest {

    @Autowired
    private iStudentRepository iStudentRepository;

    @Test
    public void saveStudent() {

    }
}