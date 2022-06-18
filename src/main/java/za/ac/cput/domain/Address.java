/* Address.java
 Entity for the address
 Author: Dominic Dave Przygonski (219206414)
 Date: 14 June 2022
*/

package za.ac.cput.domain;

import com.sun.istack.NotNull;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;

@Entity
@Embeddable
@IdClass(Address.AddressID.class)
public class Address implements Serializable {

    //-----Variables-----
    private String unitNumber;
    private String complexNumber;
    @Id
    private String streetNumber;
    @Id
    private String streetName;
    @Id
    private int postalCode;
    @ManyToOne(cascade = {PERSIST, MERGE})
    @NotFound(action = NotFoundAction.IGNORE)
    @NotNull
    private City city;


    //-----Constructor-----

    protected Address(){}

    public Address(Builder builder) {
        this.unitNumber = builder.unitNumber;
        this.complexNumber = builder.complexNumber;
        this.streetNumber = builder.streetNumber;
        this.streetName = builder.streetName;
        this.postalCode = builder.postalCode;
        this.city = builder.city;
    }


    //-----Getters and Setters-----
    public String getUnitNumber() {return unitNumber;}

    public void setUnitNumber(String unitNumber) {this.unitNumber = unitNumber;}

    public String getComplexNumber() {return complexNumber;}

    public void setComplexNumber(String complexNumber) {this.complexNumber = complexNumber;}

    public String getStreetNumber() {return streetNumber;}

    public void setStreetNumber(String streetNumber) {this.streetNumber = streetNumber;}

    public String getStreetName() {return streetName;}

    public void setStreetName(String streetName) {this.streetName = streetName;}

    public int getPostalCode() {return postalCode;}

    public void setPostalCode(int postalCode) {this.postalCode = postalCode;}

    public City getCity() {return city;}

    public void setCity(City city) {this.city = city;}

    public static class AddressID implements Serializable{
        private String streetNumber;
        private String streetName;
        private int postalCode;
        private City city;

        public AddressID(String streetNumber, String streetName, int postalCode, City city) {
            this.streetNumber = streetNumber;
            this.streetName = streetName;
            this.postalCode = postalCode;
            this.city = city;
        }

        public String getStreetNumber() {
            return streetNumber;
        }

        public String getStreetName() {
            return streetName;
        }

        public int getPostalCode() {
            return postalCode;
        }

        public City getCity() {
            return city;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            AddressID addressID = (AddressID) o;
            return postalCode == addressID.postalCode && streetNumber.equals(addressID.streetNumber) && streetName.equals(addressID.streetName)
                    && city.equals(addressID.city);
        }

        @Override
        public int hashCode() {
            return Objects.hash(streetNumber, streetName, postalCode, city);
        }
    }

    //-----Builder-----
    public static class Builder {

        private String unitNumber;
        private String complexNumber;
        private String streetNumber;
        private String streetName;
        private int postalCode;
        private City city;

        public Builder setUnitNumber(String unitNumber) {
            this.unitNumber = unitNumber;
            return this;
        }

        public Builder setComplexNumber(String complexNumber) {
            this.complexNumber = complexNumber;
            return this;
        }

        public Builder setStreetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public Builder setStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Builder setPostalCode(int postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder setCity(City city) {
            this.city = city;
            return this;
        }

        public Builder copy(Address address){
            this.unitNumber = address.unitNumber;
            this.complexNumber = address.complexNumber;
            this.streetNumber = address.streetNumber;
            this.streetName = address.streetName;
            this.postalCode = address.postalCode;
            this.city = address.city;

            return this;
        }

        public Address build(){return new Address(this);}

    }

    @Override
    public String toString() {
        return "Address{" +
                "unitNumber='" + unitNumber + '\'' +
                ", complexNumber='" + complexNumber + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city=" + city +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return postalCode == address.postalCode && streetNumber.equals(address.streetNumber)
                && streetName.equals(address.streetName) && city.equals(address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetNumber, streetName, postalCode, city);
    }
}
