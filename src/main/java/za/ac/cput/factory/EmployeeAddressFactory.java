package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.EmployeeAddress;
import za.ac.cput.helper.HelperAddress;

public class EmployeeAddressFactory {

    public static EmployeeAddress createEmployeeAddress(String staffID, Address address){

        HelperAddress.checkingStringParam("staffID", staffID);
        HelperAddress.checkingEntityParam("address", address);

        EmployeeAddress employeeAddress = new EmployeeAddress.Builder()
                .setStaffId(staffID)
                .setAddress(address)
                .build();

        return employeeAddress;
    }

    public static EmployeeAddress.EmployeeAddressID buildID(EmployeeAddress employeeAddress){
        return new EmployeeAddress.EmployeeAddressID(employeeAddress.getStaffID(), employeeAddress.getAddress());
    }

}
