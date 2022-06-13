package za.ac.cput.repository;

import za.ac.cput.domain.Country;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
 CountryRepository.java
 entity for the Country
 Author: Kamaludien Sonday (218168128)
 Date: 13/06/2022
 */
//Responsible for CRUD into a data store
public class CountryRepository implements ICountryRepository<Country, String>{
    private final List<Country> countryList;
    private static CountryRepository Country_Repository;
    private CountryRepository(){
        this.countryList = new ArrayList<>();
    }

    public static CountryRepository countryRepository(){
        if (Country_Repository == null) {
            Country_Repository = new CountryRepository();
        }
        return Country_Repository;
    }

    public Country save(Country country){
        Optional<Country> read = read(country.getCountryId());
        if (read.isPresent()){
            delete(read.get());
        }
        this.countryList.add(country);
        return country;
    }

    public Optional<Country> read(String countryId){
        return this.countryList.stream().filter(c -> c.getCountryId().equalsIgnoreCase(countryId) )
                .findAny();

    }

    public void delete(Country country){
        // finds the country if needed and deletes
        this.countryList.remove(country);
    }

    public List<Country> getAll(){
        return this.countryList;
    }

}
