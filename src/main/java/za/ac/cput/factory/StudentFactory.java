/*
 *StudentFactory.java
 * factory class for the student entity
 * Rhegan Albert Fortuin 219273693
 * Date of last edit:2022/06/16
 */

package za.ac.cput.factory;

import za.ac.cput.domain.Name;
import za.ac.cput.domain.Student;
import za.ac.cput.helper.StudentHelper;

public class StudentFactory {
    //***method to create a student using builder from Student entity***
    public static Student createStudent(String studentId, String email, Name name) {
        //ensuring values are not blank or null
        StudentHelper.isBlankOrNull(studentId);
        StudentHelper.isBlankOrNull(email);

        //***if values are invalid throw IllegalArgumentException***
        StudentHelper.checkParam("Student Id", studentId);
        StudentHelper.checkParam("Email", email);


        //***returning values to create the objects only if they are not null***
        return new Student.studentBuilder().setStudentId(studentId)
                .setEmail(email)
                .setName(name)
                .build();
    }
}
