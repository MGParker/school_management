package za.ac.cput.repository;

import za.ac.cput.domain.EmployeeAddress;
import za.ac.cput.factory.EmployeeAddressFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeAddressRepositoryImpl {
    private static EmployeeAddressRepositoryImpl repository = null;
    private final List<EmployeeAddress> EmployeeAddressDB;

    private EmployeeAddressRepositoryImpl(){
        this.EmployeeAddressDB = new ArrayList<EmployeeAddress>();
    }

    public static EmployeeAddressRepositoryImpl getRepository(){
        if(repository == null){
            repository = new EmployeeAddressRepositoryImpl();
        }
        return repository;
    }

    public EmployeeAddress save(EmployeeAddress employeeAddress){
        EmployeeAddress.EmployeeAddressID employeeAddressID = EmployeeAddressFactory.buildID(employeeAddress);
        Optional<EmployeeAddress> oldEmployeeAddress = read(employeeAddressID);
        if(oldEmployeeAddress.isPresent()){
            EmployeeAddressDB.remove(oldEmployeeAddress);
        }
        EmployeeAddressDB.add(employeeAddress);
        return employeeAddress;
    }


    public Optional<EmployeeAddress> read(EmployeeAddress.EmployeeAddressID employeeAddressID) {
        Optional<EmployeeAddress> employeeAddress = EmployeeAddressDB.stream()
                .filter(e -> e.getStaffID().equalsIgnoreCase(employeeAddressID.getStaffID()))
                .filter(e -> e.getAddress().equals(employeeAddressID.getAddress()))
                .findFirst();
        return employeeAddress;
    }



    public boolean delete(EmployeeAddress employeeAddress) {

        return  this.EmployeeAddressDB.remove(employeeAddress);
    }


    public List<EmployeeAddress> getAll() {
        return EmployeeAddressDB;
    }
}
