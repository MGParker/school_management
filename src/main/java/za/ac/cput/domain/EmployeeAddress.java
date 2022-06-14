/* EmployeeAddress.java
 Entity for the EmployeeAddress
 Author: Dominic Dave Przygonski (219206414)
 Date: 14 June 2022
*/

package za.ac.cput.domain;

import java.util.Objects;

public class EmployeeAddress {

    //-----Variables-----
    private String staffID;
    private Address address;


    //-----Constructor-----
    public EmployeeAddress(Builder builder) {
        this.staffID = builder.staffID;
        this.address = builder.address;
    }


    //-----Getters and Setters-----
    public String getStaffID() {return staffID;}

    public void setStaffID(String staffID) {this.staffID = staffID;}

    public Address getAddress() {return address;}

    public void setAddress(Address address) {this.address = address;}


    //-----Builder-----
    public static class Builder {

        private String staffID;
        private Address address;


        public Builder setStaffId(String staffID) {
            this.staffID = staffID;
            return this;
        }

        public Builder setAddress(Address address) {
            this.address = address;
            return this;
        }


        public Builder copy(EmployeeAddress employeeaddress){
            this.staffID = staffID;
            this.address = address;

            return this;
        }

        public EmployeeAddress build(){return new EmployeeAddress(this);}

    }

    @Override
    public String toString() {
        return "EmployeeAddress{" +
                "staffID='" + staffID + '\'' +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeAddress that = (EmployeeAddress) o;
        return staffID.equals(that.staffID) && address.equals(that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffID, address);
    }
}
