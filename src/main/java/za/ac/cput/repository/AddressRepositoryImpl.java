package za.ac.cput.repository;

import za.ac.cput.domain.Address;
import za.ac.cput.factory.AddressFactory;

import java.util.*;

public class AddressRepositoryImpl implements IAddressRepository{

    private static AddressRepositoryImpl repository = null;
    private final List<Address> AddressDB;

    private AddressRepositoryImpl(){
        this.AddressDB = new ArrayList<Address>();
    }

    public static AddressRepositoryImpl getRepository(){
        if(repository == null){
            repository = new AddressRepositoryImpl();
        }
        return repository;
    }

    public Address save(Address address){
        Address.AddressID addressID = AddressFactory.buildID(address);
        Optional<Address> oldAddress = read(addressID);
        if(oldAddress.isPresent()){
            AddressDB.remove(oldAddress);
        }
        AddressDB.add(address);
        return address;
    }


    public Optional<Address> read(Address.AddressID addressID) {
        Optional<Address> Address = AddressDB.stream()
                .filter(e -> e.getStreetNumber().equalsIgnoreCase(addressID.getStreetNumber()))
                .filter(e -> e.getStreetName().equalsIgnoreCase(addressID.getStreetName()))
                .filter(e -> e.getPostalCode() == addressID.getPostalCode())
                .filter(e -> e.getCity().equals(addressID.getCity()))
                .findFirst();
        return Address;
    }



    public boolean delete(Address address) {

        return  this.AddressDB.remove(address);
    }


    public List<Address> getAll() {
        return AddressDB;
    }


}
