package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.api.AddressAPI;
import za.ac.cput.domain.Address;
import za.ac.cput.service.IAddressService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("schoolManagement/address")
@Slf4j
public class AddressController {

    private final IAddressService addressService;
//    private final AddressAPI api;

//    @Autowired public AddressController(AddressAPI api) {
//        this.api = api;
//    }

    @Autowired public AddressController(IAddressService addressService){
        this.addressService = addressService;
    }

    @PostMapping("save")
    public ResponseEntity<Address> save(@Valid @RequestBody Address address){
        log.info("Save request: {}", address);
        Address response = this.addressService.save(address);
        return ResponseEntity.ok(response);
    }

    @GetMapping("read/{addressID}")
    public ResponseEntity<Address> read(@PathVariable Address.AddressID addressID){
        log.info("Read request: {}", addressID);
        Address response = this.addressService.read(addressID)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found"));
        return ResponseEntity.ok(response);
    }

    //fix address from web as cant take in a entity only string so need to find way for multiple string accaptances
    @DeleteMapping("delete/{address}")//log.info("Read request: {}", addressID);
    public ResponseEntity<Void> delete(@PathVariable Address address){
        log.info("Delete request: {}", address);
        this.addressService.delete(address);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Address>> getAll(){

        List<Address> response = this.addressService.getAll();
        return ResponseEntity.ok(response);
    }
}
