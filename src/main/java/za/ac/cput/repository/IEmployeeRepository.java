/* IEmployeeRepository.java
 Repository for Employee
 Author: Dominic Dave Przygonski (219206414)
 Date: 14 June 2022
*/
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Name;

import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, String> {

    List<Address> findByStaffID(String staffID, String email, Name name);

}