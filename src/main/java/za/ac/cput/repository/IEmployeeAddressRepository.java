package za.ac.cput.repository;

import za.ac.cput.domain.Employee;
import za.ac.cput.domain.EmployeeAddress;

import java.util.List;

public interface IEmployeeAddressRepository extends IRepository<EmployeeAddress, String>{

    public List<Employee> getAll();

}
