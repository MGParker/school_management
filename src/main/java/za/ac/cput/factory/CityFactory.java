package za.ac.cput.factory;
/*
 CityFactory.java
 Factory for the City
 Author: Mogamad Githr Parker (220408025)
 Date: 18/06/2022
 */

import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;
import za.ac.cput.helper.CityHelper;

public class CityFactory {

    public static City build(String id, String name, Country country) {
        CityHelper.checkStringParam("id", id);
        CityHelper.checkStringParam("name", name);
        CityHelper.checkingEntityParam("country", country);
        return new City.Builder().setId(id).setName(name).setCountry(country).build();
    }
}
