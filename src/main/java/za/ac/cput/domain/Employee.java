/* Employee.java
 Entity for the Employee
 Author: Dominic Dave Przygonski (219206414)
 Date: 14 June 2022
*/

package za.ac.cput.domain;

import lombok.NonNull;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Employee implements Serializable {

    //-----Variables-----
    @NonNull @Id
    private String staffID;
    @NonNull
    private String email;
    @NonNull @Embedded
    private Name name;

    //-----Constructor-----

    protected Employee(){}

    public Employee(Builder builder) {
        this.staffID = builder.staffID;
        this.email = builder.email;
        this.name = builder.name;
    }

    //-----Getters and Setters-----
    public String getStaffID() {return staffID;}

    public void setStaffID(String staffID) {this.staffID = staffID;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public Name getName() {return name;}

    public void setName(Name name) {this.name = name;}

    //-----Builder-----
    public static class Builder {

        private String staffID;
        private String email;
        private Name name;


        public Employee.Builder setStaffId(String staffID) {
            this.staffID = staffID;
            return this;
        }

        public Employee.Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Employee.Builder setName(Name name) {
            this.name = name;
            return this;
        }


        public Employee.Builder copy(Employee employee){
            this.staffID = staffID;
            this.email = email;
            this.name = name;

            return this;
        }

        public Employee build(){return new Employee(this);}

    }

    @Override
    public String toString() {
        return "Employee{" +
                "staffID='" + staffID + '\'' +
                ", email='" + email + '\'' +
                ", name=" + name +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return staffID.equals(employee.staffID) && email.equals(employee.email) && name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffID, email, name);
    }
}
