package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.City;
import za.ac.cput.service.CityService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("school/city/")
@Slf4j
public class CityController {
    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("save")
    public ResponseEntity<City> save(@RequestBody @Valid City city) {
        log.info("Save request: {}", city);
        City saved = this.cityService.save(city);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<City> read(@PathVariable String id) {
        log.info("Read request: {}", id);
        City city = this.cityService.read(id).
                orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(city);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("Read request: {}", id);
        this.cityService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("read-all")
    public ResponseEntity<List<City>> readAll() {
        List<City> cities = this.cityService.readAll();
        return ResponseEntity.ok(cities);
    }
}
