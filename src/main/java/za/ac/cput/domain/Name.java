package za.ac.cput.domain;

/*
 * Name.java
 * entity for the Name
 * Author: Benelzane Kholani (218257465)
 * Date: 13 June 2022
 *
 */

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.Objects;

@Embeddable
public class Name {

    //instance variables
    @Column(name="firstName", nullable = false)
    private String firstName;
    @Column(name="middleName", nullable = true)
    private String middleName;
    @Column(name="lastName", nullable = false)
    private String lastName;

    public Name() {

    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    private Name(NameBuilder nameBuilder)
    {
        this.firstName  = nameBuilder.firstName;
        this.middleName = nameBuilder.middleName;
        this.lastName   = nameBuilder.lastName;
    }//end of private constructor

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return firstName.equals(name.firstName) && middleName.equals(name.middleName) && lastName.equals(name.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, lastName);
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static class NameBuilder{
        private String firstName;
        private String middleName;
        private String lastName;

        public NameBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public NameBuilder setMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public NameBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Name build() {
            return new Name(this);
        }
    }//end of NameBuilder

    public static class NameID
    {
        private String firstName;
        private String middleName;
        private String lastName;

        public NameID(String firstName, String middleName, String lastName) {
            this.firstName = firstName;
            this.middleName = middleName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public String getLastName() {
            return lastName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            NameID nameID = (NameID) o;
            return firstName.equals(nameID.firstName) && Objects.equals(middleName, nameID.middleName) && lastName.equals(nameID.lastName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstName, middleName, lastName);
        }
    }

}
