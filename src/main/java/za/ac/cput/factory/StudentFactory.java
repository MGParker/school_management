package za.ac.cput.factory;

import za.ac.cput.domain.Student;
import za.ac.cput.helper.StudentHelper;

public class StudentFactory {
    //method to create a student using builder from Student entity
    public static Student createStudent(String studentId, String email, Name name){

        //returning values to create the objects only if they are not null
        if (!StudentHelper.isBlankOrEmptyOrNull(studentId) && StudentHelper.checkEmail(email) && !StudentHelper.isBlankOrEmptyOrNull(name)){
            return new Student.studentBuilder().setStudentId(studentId)
                    .setEmail(email)
                    .setName(name)
                    .Builder();
        } else {
            //confirms that values aren't blank, empty or null
            return (StudentHelper.checkParam("Student ID", studentId);
            StudentHelper.checkEmail(email);
            StudentHelper.checkParam("Name", name);
        }
    }
}
