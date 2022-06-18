/*
 *StudentFactory.java
 * factory class for the student entity
 * Rhegan Albert Fortuin 219273693
 * Date of last edit:2022/06/18
 */

package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Name;
import za.ac.cput.domain.Student;
import za.ac.cput.factory.NameFactory;
import za.ac.cput.service.INameService;
import za.ac.cput.service.student.StudentService;

import java.util.List;
import java.util.Optional;

@Component
public class StudentAPI {
    private final StudentService studentService;
    private final INameService iNameService;

    @Autowired
    public StudentAPI(StudentService studentService, INameService iNameService) {
        this.studentService = studentService;
        this.iNameService = iNameService;
    }


    public Student save(Student student) {
        Name.NameID name = NameFactory.buildID(student.getName());
        this.iNameService.read(name).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Name not found"));
        return this.studentService.save(student);
    }

    public Optional<Student> read(String string) {
        return this.studentService.read(string);
    }

    public void delete(Student student) {
        this.studentService.delete(student);
    }

    public List<Student> getAll() {
        return this.studentService.findAll();
    }
}
