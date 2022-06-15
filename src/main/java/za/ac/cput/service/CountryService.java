package za.ac.cput.service;

import za.ac.cput.domain.Country;
import za.ac.cput.repository.CountryRepository;

import java.util.Optional;

public class CountryService implements ICountryService<Country, String>{

    private final CountryRepository repository;
    private static CountryService SERVICE;

    private CountryService(){
        this.repository = CountryRepository.countryRepository();
    }

    public static CountryService getService(){
        if (SERVICE==null){
            SERVICE = new CountryService();
        }
        return SERVICE;
    }

    @Override
    public Country save(Country country) {
        return this.repository.save(country);
    }

    @Override
    public Optional<Country> read(String countryId) {
        return this.repository.read(countryId);
    }

    @Override
    public void delete(Country country) {
        this.repository.delete(country);
    }


}
