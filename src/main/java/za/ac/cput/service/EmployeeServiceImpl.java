/* EmployeeServiceImpl.java
 Implementation for EmployeeService
 Author: Dominic Dave Przygonski (219206414)
 Date: 14 June 2022
*/
package za.ac.cput.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Name;
import za.ac.cput.helper.HelperAddress;
import za.ac.cput.repository.IAddressRepository;
import za.ac.cput.repository.IEmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

    private static IEmployeeRepository repository = null;
    private static IAddressRepository addressRepository = null;


    @Autowired private EmployeeServiceImpl(IEmployeeRepository employeesRepository, IAddressRepository addressRepository){
        this.repository = employeesRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public Employee save(Employee employee) {
        return this.repository.save(employee);
    }

    @Override
    public Optional<Employee> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Employee employee) {
        this.repository.delete(employee);
    }

    @Override
    public List<Employee> getAll() {
        return this.repository.findAll();
    }

    //Question 5
//    @Override
//    public Name getEmployeeNameByEmail(String email){
//        HelperAddress.checkingEmailParam("email", email );
//        List<Employee> empList = this.repository.findAll();
//        for(Employee emp: empList){
//            if(emp.getEmail().equals(email)){
//                return emp.getName();
//            }
//        }
//         return null;
//    }

    //Question 5
    @Override
    public Optional<Employee> findByEmail(String email) {
        return Optional.empty();
    }


}
