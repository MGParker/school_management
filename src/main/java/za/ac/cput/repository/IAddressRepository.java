package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.City;

import java.util.List;
@Repository
public interface IAddressRepository extends JpaRepository<Address, Address.AddressID> {

//    public List<Address> getAll();
    List<Address> findByStreetNumberAndStreetNameAndPostalCodeAndCity(String streetNumber, String streetName, int postalCode, City city);

}
