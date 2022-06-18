package za.ac.cput.service;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.EmployeeAddress;
import za.ac.cput.repository.AddressRepositoryImpl;
import za.ac.cput.repository.EmployeeAddressRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class EmployeeAddressServiceImpl implements IEmployeeAddressService {

    private static EmployeeAddressRepositoryImpl repository = null;
    private static IEmployeeAddressService SERVICE;


    private EmployeeAddressServiceImpl() {
        this.repository = EmployeeAddressRepositoryImpl.getRepository();
    }

    public static IEmployeeAddressService getService() {
        if (SERVICE == null) {
            SERVICE = new EmployeeAddressServiceImpl();
        }
        return SERVICE;
    }

    @Override
    public EmployeeAddress save(EmployeeAddress employeeAddress) {
        return this.repository.save(employeeAddress);
    }

    @Override
    public Optional<EmployeeAddress> read(EmployeeAddress.EmployeeAddressID employeeAddressID) {
        return this.repository.read(employeeAddressID);
    }

    @Override
    public boolean delete(EmployeeAddress employeeAddress) {
        return this.repository.delete(employeeAddress);
    }

    @Override
    public List<EmployeeAddress> getAll() {
        return this.repository.getAll();
    }
}
