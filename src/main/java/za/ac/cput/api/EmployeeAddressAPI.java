/* AddressAPI.java
   API for address controller
   Author: Dominic Dave Przygonski (219206414)
   Date: 14 June 2022
  */
package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.City;
import za.ac.cput.domain.EmployeeAddress;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.service.CityService;
import za.ac.cput.service.IAddressService;
import za.ac.cput.service.IEmployeeAddressService;
import za.ac.cput.service.INameService;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeAddressAPI {

    private final IEmployeeAddressService employeeAddressService;
    private final IAddressService addressService;

    @Autowired
    public EmployeeAddressAPI(IEmployeeAddressService employeeAddressService, IAddressService addressService) {
        this.employeeAddressService = employeeAddressService;
        this.addressService = addressService;
    }


    public EmployeeAddress save(EmployeeAddress employeeAddress) {
        Address.AddressID addressID = AddressFactory.buildID(employeeAddress.getAddress());
        this.addressService.read(addressID).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found"));
        return this.employeeAddressService.save(employeeAddress);
    }

    public Optional<EmployeeAddress> read(EmployeeAddress.EmployeeAddressID employeeAddressID) {
        return this.employeeAddressService.read(employeeAddressID);
    }

    public void delete(EmployeeAddress employeeAddress) {
        this.employeeAddressService.delete(employeeAddress);
    }


    public List<EmployeeAddress> getAll() {
        return this.employeeAddressService.getAll();
    }
}