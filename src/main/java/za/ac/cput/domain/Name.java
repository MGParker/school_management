package za.ac.cput.domain;

/*
 * Name.java
 * entity for the Name
 * Author: Benelzane Kholani (218257465)
 * Date: 13 June 2022
 *
 */

import java.util.Objects;

public class Name {

    //instance variables
    private String firstName;
    private String middleName;
    private String lastName;

    private Name(NameBuilder nameBuilder)
    {
        this.firstName  = nameBuilder.firstName;
        this.middleName = nameBuilder.middleName;
        this.lastName   = nameBuilder.lastName;
    }//end of private constructor

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
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

        public NameBuilder copy(Name name){
            this.firstName  = name.firstName;
            this.middleName = name.middleName;
            this.lastName   = name.lastName;
            return this;
        }

        public Name getName(){
            return new Name(this);
        }//end of getName method

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Name name = (Name) o;
            return firstName.equals(name.firstName) && middleName.equals(name.middleName) && lastName.equals(name.lastName) ;
        }//end of equals method

        @Override
        public int hashCode() {
            return Objects.hash(firstName, middleName, lastName);
        }//end of hashCode method

        @Override
        public String toString() {
            return "NameBuilder{" +
                    "firstName='" + firstName + '\'' +
                    ", middleName='" + middleName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }//end of NameBuilder
}
