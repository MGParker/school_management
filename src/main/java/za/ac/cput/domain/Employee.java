package za.ac.cput.domain;

import java.util.Objects;

public class Employee {

    //-----Variables-----
    private String staffID;
    private String email;
    private Name name;

    //-----Constructor-----
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
