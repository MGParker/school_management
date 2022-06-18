package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.City;
import za.ac.cput.helper.HelperAddress;

public class AddressFactory {

    public static Address createAddress(String unitNumber, String complexNumber, String streetNumber, String streetName, int postalCode, City city){

        unitNumber = HelperAddress.setEmptyIfNull(unitNumber);
        complexNumber = HelperAddress.setEmptyIfNull(complexNumber);
        HelperAddress.checkingStringParam("streetNumber", streetNumber);
        HelperAddress.checkingStringParam("streetName", streetName);
        HelperAddress.checkingIntParam("postalCode", postalCode);
        HelperAddress.checkingEntityParam("city", city);

        Address address = new Address.Builder()
                .setUnitNumber(unitNumber)
                .setComplexNumber(complexNumber)
                .setStreetNumber(streetNumber)
                .setStreetName(streetName)
                .setPostalCode(postalCode)
                .setCity(city)
                .build();

        return address;
    }

    public static Address.AddressID buildID(Address address){
        return new Address.AddressID(address.getStreetNumber(), address.getStreetName(), address.getPostalCode(), address.getCity());
    }

}
