/*
 * StudentService.java
 * StudentService which extends iService
 * Rhegan Albert Fortuin 219273693
 * Date of last edit:2022/06/18
 */

package za.ac.cput.service.student;

import za.ac.cput.domain.Student;

import java.util.List;

public interface StudentService extends iService<Student, String> {
    List<Student> findAll();
}
