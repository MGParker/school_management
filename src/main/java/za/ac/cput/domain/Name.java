package za.ac.cput.domain;

/*
 * Name.java
 * entity for the Name
 * Author: Benelzane Kholani (218257465)
 * Date: 18 June 2022
 *
 */

public class Name {

    //instance variables
    private String firstName;
    private String middleName;
    private String lastName;

    private Name()
    {}//end of private constructor

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

        public Name getName(){
            Name name       = new Name();
            name.firstName  = this.firstName;
            name.middleName = this.middleName;
            name.lastName   = this.lastName;

            return name;
        }//end of getName method
    }//end of NameBuilder
}
