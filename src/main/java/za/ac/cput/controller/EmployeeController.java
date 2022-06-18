/* EmployeeController.java
 Controller for employee entity
 Author: Dominic Dave Przygonski (219206414)
 Date: 14 June 2022
*/
/*
 EmployeeController.java
 Author: Kamaludien Sonday (218168128)
 */
package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.api.EmployeeAPI;
import za.ac.cput.api.EmployeeAddressAPI;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Name;
import za.ac.cput.helper.HelperAddress;
import za.ac.cput.service.IEmployeeService;

import java.util.List;

@RestController
@RequestMapping("schoolManagement/employee")
@Slf4j
public class EmployeeController {

    private final IEmployeeService employeeService;
    private final EmployeeAPI api;

    @Autowired public EmployeeController(EmployeeAPI api, IEmployeeService employeeService) {
        this.api = api;
        this.employeeService = employeeService;
    }

    @PostMapping("save")
    public ResponseEntity<Employee> save(@RequestBody Employee employee){
        log.info("Save request: {}", employee);
        try{
            Employee response = this.api.save(employee);
            return ResponseEntity.ok(response);
        } catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }

    @GetMapping("read/{staffId}")
    public ResponseEntity<Employee> read(@PathVariable String staffId){
        log.info("Read request: {}", staffId);
        Employee response = this.api.read(staffId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("delete/{Employee}")//log.info("Read request: {}", EmployeeID);
    public ResponseEntity<Void> delete(@PathVariable Employee employee){
        log.info("Delete request: {}", employee);
        this.api.delete(employee);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Employee>> getAll(){

        List<Employee> response = this.api.getAll();
        return ResponseEntity.ok(response);
    }

    //Question 5
    @GetMapping("read-by-email/{email}")
    public ResponseEntity<Name> findByEmail(@PathVariable String email){
        log.info("Read name by email request: {}", email);
        try {
            HelperAddress.checkingEmailParam(email);
        } catch (IllegalArgumentException e){
            log.info("Error finding name by email: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Employee employee = this.employeeService.findByEmail(email).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(employee.getName());
    }
}
