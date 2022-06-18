/* IEmployeeAddressRepository.java
 Repository for EmployeeAddress
 Author: Dominic Dave Przygonski (219206414)
 Date: 14 June 2022
*/
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.EmployeeAddress;

import java.util.List;

@Repository
public interface IEmployeeAddressRepository extends JpaRepository<EmployeeAddress, EmployeeAddress.EmployeeAddressID> {

    List<EmployeeAddress> findByStaffIDAndAddress(String staffID, Address address);

}
