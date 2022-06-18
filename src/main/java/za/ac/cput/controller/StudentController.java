/*
 * StudentController.java
 * Controller class for student
 * Rhegan Albert Fortuin 219273693
 * Date of last edit:2022/06/16
 */

package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Student;
import za.ac.cput.service.student.StudentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/school_management/student")
@Slf4j
public class StudentController {
    private final StudentService StudentService;

    @Autowired
    public StudentController(StudentService StudentService) {
        this.StudentService = StudentService;
    }

    @PostMapping("/save")
    public ResponseEntity<Student> save(@Valid @RequestBody Student student) {
        log.info("Save request: {}", student);
        System.out.println(String.format("Save request: ", student));
        Student save = StudentService.save(student);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{staffId}")
    public ResponseEntity<Student> read(@PathVariable String studentId) {
        log.info("Read request: {}", studentId);
        Student student =
                this.StudentService.read(studentId).get();
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("delete/{staffId}")
    public ResponseEntity<Void> delete(@PathVariable String studentId) {
        log.info("Delete request: {}", studentId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Student>> findAll() {
        List<Student> student = this.StudentService.findAll();
        return ResponseEntity.ok(student);
    }
}