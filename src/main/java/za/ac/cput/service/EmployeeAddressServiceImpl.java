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
//    private static IEmployeeAddressService SERVICE;


    @Autowired private EmployeeAddressServiceImpl(IEmployeeAddressRepository employeeAddressRepository) {
        this.repository = employeeAddressRepository;
    }

//    public static IEmployeeAddressService getService() {
//        if (SERVICE == null) {
//            SERVICE = new EmployeeAddressServiceImpl();
//        }
//        return SERVICE;
//    }

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
