package za.ac.cput.domain;

/*
 * Name.java
 * entity for the Name
 * Author: Benelzane Kholani (218257465)
 * Date: 13 June 2022
 *
 */

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
@Embeddable
public class Name {

    //instance variables
    private String firstName;
    private String middleName;
    private String lastName;

    public Name() {

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

}
