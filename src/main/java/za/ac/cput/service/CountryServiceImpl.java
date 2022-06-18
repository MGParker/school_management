package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Country;
import za.ac.cput.repository.CountryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements ICountryService<Country, String>{

    private final CountryRepository repository;

    private CountryServiceImpl(CountryRepository repository){
        this.repository = repository;
    }

    @Override
    public Country save(Country country) {
        return this.repository.save(country);
    }

    @Override
    public Optional<Country> read(String countryId) {
        return this.repository.findById(countryId);
    }

    @Override
    public void delete(Country country) {
        this.repository.delete(country);
    }

    @Override
    public void deleteById(String s) {
        Optional<Country> country = read(s);
        country.ifPresent(this::delete);
    }

    public List<Country> getAll(){
        return this.repository.findAll();
    }


}
