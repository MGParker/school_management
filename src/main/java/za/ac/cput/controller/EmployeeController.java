package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Employee;
import za.ac.cput.service.IEmployeeService;

import java.util.List;

@RestController
@RequestMapping("schoolManagement/employee")
@Slf4j
public class EmployeeController {

    private final IEmployeeService EmployeeService;

    @Autowired
    public EmployeeController(IEmployeeService EmployeeService){
        this.EmployeeService = EmployeeService;
    }

    @PostMapping("save")
    public ResponseEntity<Employee> save(@RequestBody Employee employee){
        log.info("Save request: {}", employee);
        try{
            Employee response = this.EmployeeService.save(employee);
            return ResponseEntity.ok(response);
        } catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }

    @GetMapping("read/{staffId}")
    public ResponseEntity<Employee> read(@PathVariable String staffId){
        log.info("Read request: {}", staffId);
        Employee response = this.EmployeeService.read(staffId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
        return ResponseEntity.ok(response);
    }

    //fix Employee from web as cant take in a entity only string so need to find way for multiple string accaptances
    @DeleteMapping("delete/{Employee}")//log.info("Read request: {}", EmployeeID);
    public ResponseEntity<Void> delete(@PathVariable Employee employee){
        log.info("Delete request: {}", employee);
        this.EmployeeService.delete(employee);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Employee>> getAll(){

        List<Employee> response = this.EmployeeService.getAll();
        return ResponseEntity.ok(response);
    }
}
