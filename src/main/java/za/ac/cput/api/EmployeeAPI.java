package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.EmployeeAddress;
import za.ac.cput.domain.Name;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.NameFactory;
import za.ac.cput.service.IAddressService;
import za.ac.cput.service.IEmployeeAddressService;
import za.ac.cput.service.IEmployeeService;
import za.ac.cput.service.INameService;

import java.util.List;
import java.util.Optional;

/*
 * Name.java
 * entity for the Name
 * Author: Dominic Dave Przygonski (219206414) & Benelzane Kholani (218257465)
 * Date: 17 June 2022
 *
 */

@Component
public class EmployeeAPI {

    private final IEmployeeService employeeService;
    private final INameService nameService;

    @Autowired
    public EmployeeAPI(IEmployeeService employeeService, INameService nameService) {
        this.employeeService = employeeService;
        this.nameService = nameService;
    }


    public Employee save(Employee employee) {
        Name.NameID name = NameFactory.buildID(employee.getName());
        this.nameService.read(name).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Name not found"));
        return this.employeeService.save(employee);
    }

    public Optional<Employee> read(String employeeAddressID) {
        return this.employeeService.read(employeeAddressID);
    }

    public void delete(Employee employee) {
        this.employeeService.delete(employee);
    }

    public List<Employee> getAll() {
        return this.employeeService.getAll();
    }
}
