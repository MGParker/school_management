package za.ac.cput.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Employee;
import za.ac.cput.repository.IEmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

    private static IEmployeeRepository repository = null;
//    private static IEmployeeService SERVICE;


    @Autowired private EmployeeServiceImpl(IEmployeeRepository employeesRepository){
        this.repository = employeesRepository;
    }

//    public static IEmployeeService getService(){
//        if(SERVICE == null){
//            SERVICE = new EmployeeServiceImpl();
//        }
//        return SERVICE;
//    }

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
}
