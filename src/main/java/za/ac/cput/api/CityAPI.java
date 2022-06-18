/*package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.City;
import za.ac.cput.service.CityService;

import java.util.Optional;

@Component
public class CityAPI {
    private final CityService cityService;

    @Autowired public CityAPI(CityService cityService) {
        this.cityService = cityService;
    }

    public City save(City city) {
        this.cityService.read(city.getCountry()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Country Not Found"));
        return this.cityService.save(city);
    }
}*/
