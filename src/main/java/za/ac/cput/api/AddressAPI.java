/* AddressAPI.java
 API for address controller
 Author: Dominic Dave Przygonski (219206414)
 Date: 14 June 2022
*/
package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.City;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.service.CityService;
import za.ac.cput.service.IAddressService;
import za.ac.cput.service.IEmployeeAddressService;

import java.util.List;
import java.util.Optional;

@Component
public class AddressAPI {

    private final IAddressService addressService;
    private final CityService cityService;

    @Autowired
    public AddressAPI(IAddressService addressService, CityService cityService) {
        this.addressService = addressService;
        this.cityService = cityService;
    }


    public Address save(Address address) {
        this.cityService.read(address.getCity().getId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "City not found"));
        return this.addressService.save(address);
    }

    public Optional<Address> read(Address.AddressID addressID) {
        return this.addressService.read(addressID);
    }

    public void delete(Address address) {
        this.addressService.delete(address);
    }


    public List<Address> getAll() {
        return this.addressService.getAll();
    }
}
