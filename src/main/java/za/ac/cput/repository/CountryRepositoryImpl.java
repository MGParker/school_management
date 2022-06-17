package za.ac.cput.repository;

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Country;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
 CountryRepositoryImpl.java
 entity for the Country
 Author: Kamaludien Sonday (218168128)
 Date: 13/06/2022
 */

@Repository
public class CountryRepositoryImpl implements ICountryRepository<Country, String>{
    private final List<Country> countryList;
    private CountryRepositoryImpl(){
        this.countryList = new ArrayList<>();
    }

    @Override
    public Country save(Country country){
        Optional<Country> read = read(country.getCountryId());
        if (read.isPresent()){
            delete(read.get());
        }
        this.countryList.add(country);
        return country;
    }

    @Override
    public Optional<Country> read(String countryId){
        return this.countryList.stream().filter(c -> c.getCountryId().equalsIgnoreCase(countryId) )
                .findAny();

    }

    @Override
    public void delete(Country country){
        // finds the country if needed and deletes
        this.countryList.remove(country);
    }

    @Override
    public List<Country> getAll(){
        return this.countryList;
    }

}
