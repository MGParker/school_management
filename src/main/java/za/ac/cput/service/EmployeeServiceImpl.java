package za.ac.cput.service;


import za.ac.cput.domain.Employee;
import za.ac.cput.repository.EmployeeRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements IEmployeeService{

    private static EmployeeRepositoryImpl repository = null;
    private static IEmployeeService SERVICE;


    private EmployeeServiceImpl(){
        this.repository = EmployeeRepositoryImpl.getRepository();
    }

    public static IEmployeeService getService(){
        if(SERVICE == null){
            SERVICE = new EmployeeServiceImpl();
        }
        return SERVICE;
    }

    @Override
    public Employee save(Employee employee) {
        return this.repository.save(employee);
    }

    @Override
    public Optional<Employee> read(String id) {
        return this.repository.read(id);
    }

    @Override
    public boolean delete(Employee employee) {
        return this.repository.delete(employee);
    }

    @Override
    public List<Employee> getAll() {
        return this.repository.getAll();
    }
}
