/* EmployeeFactory.java
 Factory for Employee entity
 Author: Dominic Dave Przygonski (219206414)
 Date: 14 June 2022
*/
package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.EmployeeAddress;
import za.ac.cput.domain.Name;
import za.ac.cput.helper.HelperAddress;

public class EmployeeFactory {

    public static Employee createEmployee(String staffID, String email, Name name){

        HelperAddress.checkingStringParam("staffID", staffID);
        HelperAddress.checkingEmailParam("email", email);
        HelperAddress.checkingEntityParam("name", name);


        Employee employee = new Employee.Builder()
                .setStaffId(staffID)
                .setEmail(email)
                .setName(name)
                .build();

        return employee;
    }
}
