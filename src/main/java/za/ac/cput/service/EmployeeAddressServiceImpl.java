/* EmployeeAddressServiceImpl.java
 Implementation for EmployeeAddressService
 Author: Dominic Dave Przygonski (219206414)
 Date: 14 June 2022
*/
package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.EmployeeAddress;

import za.ac.cput.repository.IEmployeeAddressRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeAddressServiceImpl implements IEmployeeAddressService {

    private static IEmployeeAddressRepository repository = null;

    @Autowired private EmployeeAddressServiceImpl(IEmployeeAddressRepository employeeAddressRepository) {
        this.repository = employeeAddressRepository;
    }

    @Override
    public EmployeeAddress save(EmployeeAddress employeeAddress) {
        return this.repository.save(employeeAddress);
    }

    @Override
    public Optional<EmployeeAddress> read(EmployeeAddress.EmployeeAddressID employeeAddressID) {
        return this.repository.findById(employeeAddressID);
    }

    @Override
    public void delete(EmployeeAddress employeeAddress) {
        this.repository.delete(employeeAddress);
    }

    @Override
    public List<EmployeeAddress> getAll() {
        return this.repository.findAll();
    }
}
