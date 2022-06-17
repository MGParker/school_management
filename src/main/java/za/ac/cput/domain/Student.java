/*
 * Student.java
 * entity class for student with a builder
 * Rhegan Albert Fortuin 219273693
 * Date of last edit:2022/06/16
 */

package za.ac.cput.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Student")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Student")
public class Student {

    //***declare variables***
    @Id
    @Column(name = "studentId", updatable = false, nullable = false, columnDefinition = "TEXT", unique = true)
    private String studentId;
    @Column(name = "email", updatable = false, nullable = false, columnDefinition = "TEXT", unique = true)
    private String email;
    @Embedded
    @Column(name = "name", updatable = false, nullable = false, columnDefinition = "TEXT")
    private Name name;

    //***constructor for the builder***
    public Student(studentBuilder builder) {
        this.studentId = builder.studentId;
        this.email = builder.email;
        this.name = builder.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId.equals(student.studentId) && email.equals(student.email) && name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, email, name);
    }

    //***create variables into a toString***
    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", email='" + email + '\'' +
                ", name=" + name +
                '}';
    }

    //***builder pattern class for student***
    public static class studentBuilder {
        private String studentId;
        private String email;
        private Name name;

        //***setting the studentId, email and name for the builder***
        public studentBuilder setStudentId(String studentId) {
            this.studentId = studentId;
            return this;
        }

        public studentBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public studentBuilder setName(Name name) {
            this.name = name;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
