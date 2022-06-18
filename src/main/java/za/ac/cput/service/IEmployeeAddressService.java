/* IEmployeeAddressService.java
 Service for EmployeeAddress
 Author: Dominic Dave Przygonski (219206414)
 Date: 14 June 2022
*/
package za.ac.cput.service;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.EmployeeAddress;

import java.util.List;

public interface IEmployeeAddressService extends IService<EmployeeAddress, EmployeeAddress.EmployeeAddressID>{
    List<EmployeeAddress> getAll();
}
