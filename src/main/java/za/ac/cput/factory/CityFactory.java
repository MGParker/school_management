package za.ac.cput.factory;

import za.ac.cput.domain.City;
import za.ac.cput.helper.CityHelper;

public class CityFactory {

    public static City build(String id, String name, Country country) {
        CityHelper.checkStringParam("id", id);
        CityHelper.checkStringParam("name", name);
        if (country == null || country.isEmpty())
            throw new IllegalArgumentException("Invalid value for param: country");
        return new City.Builder().setId(id).setName(name).setCountry(country).build();
    }
}
