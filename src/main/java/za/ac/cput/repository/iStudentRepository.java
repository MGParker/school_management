/*
 * iStudentRepository.java
 * iStudentRepository which is the repo for student
 * Rhegan Albert Fortuin 219273693
 * Date of last edit:2022/06/18
 */

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Student;

@Repository
public interface iStudentRepository extends JpaRepository<Student, String> {

}
