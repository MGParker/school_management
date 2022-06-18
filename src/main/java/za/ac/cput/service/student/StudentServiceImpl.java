/*
 * Student.java
 * implementation of the service class
 * Rhegan Albert Fortuin 219273693
 * Date of last edit:2022/06/18
 */

package za.ac.cput.service.student;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.Student;
import za.ac.cput.repository.iStudentRepository;

import java.util.List;
import java.util.Optional;

public class StudentServiceImpl implements StudentService {
    @Autowired
    private iStudentRepository iStudentRepository;

    public StudentServiceImpl(iStudentRepository iStudentRepository) {
        this.iStudentRepository = iStudentRepository;
    }


    @Override
    public List<Student> findAll() {
        return this.iStudentRepository.findAll();
    }

    @Override
    public Student save(Student student) {
        return this.iStudentRepository.save(student);
    }

    @Override
    public Optional<Student> read(String string) {
        return this.iStudentRepository.findById(string);
    }

    @Override
    public void delete(Student student) {
        this.iStudentRepository.delete(student);
    }
}
