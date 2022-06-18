/* EmployeeAddressController.java
 Controller for EmployeeAddress entity
 Author: Dominic Dave Przygonski (219206414)
 Date: 14 June 2022
*/
package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.api.AddressAPI;
import za.ac.cput.api.EmployeeAddressAPI;
import za.ac.cput.domain.EmployeeAddress;
import za.ac.cput.service.IEmployeeAddressService;

import java.util.List;
@RestController
@RequestMapping("schoolManagement/employeeAddress")
@Slf4j
public class EmployeeAddressController {

    private final EmployeeAddressAPI api;

    @Autowired public EmployeeAddressController(EmployeeAddressAPI api) {
        this.api = api;
    }


    @PostMapping("save")
    public ResponseEntity<EmployeeAddress> save(@RequestBody EmployeeAddress employeeAddress){
        log.info("Save request: {}", employeeAddress);
        try{
            EmployeeAddress response = this.api.save(employeeAddress);
            return ResponseEntity.ok(response);
        } catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }

    @GetMapping("read/{EmployeeAddressID}")
    public ResponseEntity<EmployeeAddress> read(@PathVariable EmployeeAddress.EmployeeAddressID employeeAddressID){
        log.info("Read request: {}", employeeAddressID);
        EmployeeAddress response = this.api.read(employeeAddressID)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "EmployeeAddress not found"));
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("delete/{EmployeeAddress}")
    public ResponseEntity<Void> delete(@PathVariable EmployeeAddress employeeAddress){
        log.info("Delete request: {}", employeeAddress);
        this.api.delete(employeeAddress);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<EmployeeAddress>> getAll(){

        List<EmployeeAddress> response = this.api.getAll();
        return ResponseEntity.ok(response);
    }
}
