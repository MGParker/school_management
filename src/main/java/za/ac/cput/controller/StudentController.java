/*
 * StudentController.java
 * Controller class for student
 * Rhegan Albert Fortuin 219273693
 * Date of last edit:2022/06/16
 */

package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.service.student.StudentServiceImpl;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;
}