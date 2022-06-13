package za.ac.cput.factory;
/*
 CountryFactory.java
 entity for the Country
 Author: Kamaludien Sonday (218168128)
 Date: 13/06/2022
 */

import za.ac.cput.domain.Country;
import za.ac.cput.helper.Helper;

public class CountryFactory {
    public static Country createCountry(String countryName){
        if (Helper.isNullEmpty(countryName)){
            return null;
        }

        String countryId = Helper.generateId();

        Country country = new Country.Builder().countryId(countryId).countryName(countryName).build();
        return country;

    }
}
