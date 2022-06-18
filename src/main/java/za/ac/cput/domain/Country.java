package za.ac.cput.domain;
/*
 Country.java
 entity for the Country
 Author: Kamaludien Sonday (218168128)
 Date: 13/06/2022
 */

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;
@Entity
@Embeddable
public class Country implements Serializable {
    @Id
    private String countryId;

    private String countryName;

    public Country(Builder builder) {
        this.countryId = builder.countryId;
        this.countryName = builder.countryName;
    }

    protected Country() {

    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryId() {
        return countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(countryId, country.countryId) && Objects.equals(countryName, country.countryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, countryName);
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryId='" + countryId + '\'' +
                ", countryName='" + countryName + '\'' +
                '}';
    }

    public static class Builder{
        private String countryId, countryName;

        public Builder countryId(String countryId){
            this.countryId = countryId;
            return this;
        }

        public Builder countryName(String countryName){
            this.countryName = countryName;
            return this;
        }

        public Builder copy(Country country){
            this.countryId = country.countryId;
            this.countryName = country.countryName;
            return this;

        }

        public Country build(){
            return new Country(this);
        }
    }
}
