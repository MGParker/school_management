/* IAddressService.java
 Service for address
 Author: Dominic Dave Przygonski (219206414)
 Date: 14 June 2022
*/
package za.ac.cput.service;

import za.ac.cput.domain.Address;

import java.util.List;

public interface IAddressService extends IService<Address, Address.AddressID>{
    List<Address> getAll();
}
