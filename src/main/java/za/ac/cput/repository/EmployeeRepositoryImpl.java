package za.ac.cput.repository;

import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeRepositoryImpl implements IEmployeeRepository{

    private static EmployeeRepositoryImpl repository = null;
    private final List<Employee> EmployeeDB;

    private EmployeeRepositoryImpl(){
        this.EmployeeDB = new ArrayList<Employee>();
    }

    public static EmployeeRepositoryImpl getRepository(){
        if(repository == null){
            repository = new EmployeeRepositoryImpl();
        }
        return repository;
    }

    public Employee save(Employee employee){
        Optional<Employee> oldEmployee = read(employee.getStaffID());
        if(oldEmployee.isPresent()){
            EmployeeDB.remove(oldEmployee);
        }
        EmployeeDB.add(employee);
        return employee;
    }


    public Optional<Employee> read(String id) {
        Optional<Employee> employee = EmployeeDB.stream()
                .filter(e -> e.getStaffID().equalsIgnoreCase(id))
                .findFirst();
        return employee;
    }



    public boolean delete(Employee Employee) {

        return  this.EmployeeDB.remove(Employee);
    }


    public List<Employee> getAll() {
        return EmployeeDB;
    }
}
