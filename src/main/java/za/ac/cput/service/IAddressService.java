package za.ac.cput.service;

import za.ac.cput.domain.Address;

import java.util.List;

public interface IAddressService extends IService<Address, Address.AddressID>{
    List<Address> getAll();
}
