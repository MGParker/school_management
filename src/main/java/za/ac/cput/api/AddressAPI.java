package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.cput.domain.Address;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.service.IAddressService;

import java.util.Optional;

@Component
public class AddressAPI {

//    private final IAddressService service;


//    @Autowired public AddressAPI(IAddressService service) {
//        this.service = service;
//    }
//
//    public Address save(Address address) {
//        Address.AddressID addressID = AddressFactory.buildID(address);
//        Optional<Address> read = this.service.read(addressID);
//        if(read.isPresent()){
//
//        }
//    }
}
