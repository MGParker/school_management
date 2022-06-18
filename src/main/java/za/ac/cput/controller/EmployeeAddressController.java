package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.EmployeeAddress;
import za.ac.cput.service.IEmployeeAddressService;

import java.util.List;
@RestController
@RequestMapping("schoolManagement/employeeAddress")
@Slf4j
public class EmployeeAddressController {

    private final IEmployeeAddressService employeeAddressService;

    @Autowired
    public EmployeeAddressController(IEmployeeAddressService employeeAddressService){
        this.employeeAddressService = employeeAddressService;
    }

    @PostMapping("save")
    public ResponseEntity<EmployeeAddress> save(@RequestBody EmployeeAddress employeeAddress){
        log.info("Save request: {}", employeeAddress);
        try{
            EmployeeAddress response = this.employeeAddressService.save(employeeAddress);
            return ResponseEntity.ok(response);
        } catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }

    @GetMapping("read/{EmployeeAddressID}")
    public ResponseEntity<EmployeeAddress> read(@PathVariable EmployeeAddress.EmployeeAddressID employeeAddressID){
        log.info("Read request: {}", employeeAddressID);
        EmployeeAddress response = this.employeeAddressService.read(employeeAddressID)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "EmployeeAddress not found"));
        return ResponseEntity.ok(response);
    }

    //fix EmployeeAddress from web as cant take in a entity only string so need to find way for multiple string accaptances
    @DeleteMapping("delete/{EmployeeAddress}")//log.info("Read request: {}", EmployeeAddressID);
    public ResponseEntity<Void> delete(@PathVariable EmployeeAddress employeeAddress){
        log.info("Delete request: {}", employeeAddress);
        this.employeeAddressService.delete(employeeAddress);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<EmployeeAddress>> getAll(){

        List<EmployeeAddress> response = this.employeeAddressService.getAll();
        return ResponseEntity.ok(response);
    }
}
