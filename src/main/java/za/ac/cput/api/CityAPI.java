<<<<<<< HEAD
/*
=======
>>>>>>> 1e59caaecf8428269e26544978a70f4ad163af34
package za.ac.cput.api;
/*
 CityApi.java
 Author: Kamaludien Sonday (218168128)
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;
import za.ac.cput.service.CityService;
import za.ac.cput.service.CountryServiceImpl;
import za.ac.cput.service.ICountryService;

import java.util.*;

@Component
public class CityAPI {
    private final CityService cityService;
    private final CountryServiceImpl countryService;

    @Autowired
    public CityAPI(CountryServiceImpl countryService, CityService cityService) {
        this.countryService= countryService;
        this.cityService = cityService;
    }

//    public City save(City city) {
//        this.cityService.read(city.getCountry()).orElseThrow(
//                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Country Not Found"));
//        return this.cityService.save(city);
//    }

    //Question 7
    public List<String> findCitiesByCountry(String countryId){
        try {
            Country country = this.countryService.read(countryId).get();
            List<City> citiesFound = this.cityService.findCitiesByCountry(country);
            if (citiesFound != null && citiesFound.size() >0){
                List<String> cityNames = new ArrayList<>();
                citiesFound.forEach(city -> cityNames.add(city.getName()));
                Collections.sort(cityNames);
                return cityNames;
            }
        }
        catch (NoSuchElementException e){
            return null;
        }
        return null;
    }
}
