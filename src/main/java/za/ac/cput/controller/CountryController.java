package za.ac.cput.controller;
/*
 CityController.java
 Author: Kamaludien Sonday (218168128)
 */

import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Country;
import za.ac.cput.service.CountryServiceImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("school_management/country/")
@Slf4j
public class CountryController {
    private final CountryServiceImpl countryService;

    @Autowired public CountryController(CountryServiceImpl countryService){
        this.countryService = countryService;
    }

    @PostMapping("save")
    public ResponseEntity<Country> save(@Valid @RequestBody Country country){
        log.info("Save request: {}", country);
        Country save = countryService.save(country);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{countryId}")
    public ResponseEntity<Country> read(@PathVariable String countryId){
        log.info("Read request: {}", countryId);
        Country country = this.countryService.read(countryId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(country);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("Delete request: {}", id);
        this.countryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Country>> getAll(){
        List<Country> countries = this.countryService.getAll();
        return ResponseEntity.ok(countries);
    }
}
