package za.ac.cput.service;

import za.ac.cput.domain.Address;
import za.ac.cput.repository.AddressRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddressServiceImpl implements IAddressService{

    private static AddressRepositoryImpl repository = null;
    private static IAddressService SERVICE;


    private AddressServiceImpl(){
        this.repository = AddressRepositoryImpl.getRepository();
    }

    public static IAddressService getService(){
        if(SERVICE == null){
            SERVICE = new AddressServiceImpl();
        }
        return SERVICE;
    }

    @Override
    public Address save(Address address) {
        return this.repository.save(address);
    }

    @Override
    public Optional<Address> read(Address.AddressID addressID) {
        return this.repository.read(addressID);
    }

    @Override
    public boolean delete(Address address) {
        return this.repository.delete(address);
    }

    @Override
    public List<Address> getAll() {
        return this.repository.getAll();
    }
}
