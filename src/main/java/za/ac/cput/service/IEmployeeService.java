/* IEmployeeService.java
 Service for Employee
 Author: Dominic Dave Przygonski (219206414)
 Date: 14 June 2022
*/
package za.ac.cput.service;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Name;

import java.util.List;

public interface IEmployeeService extends IService<Employee, String>{
    List<Employee> getAll();

    //Question 5
    Name getEmployeeNameByEmail(String email);

    //Question 6
    List<Name> getEmployeeNamesByCity(String cityID);
}
