package za.ac.cput.factory;

/*
 * Name.java
 * entity for the Name
 * Author: Benelzane Kholani (218257465)
 * Date: 13 June 2022
 *
 */

import za.ac.cput.domain.Name;
import za.ac.cput.helper.NameHelper;

public class NameFactory {

    public static Name getName(String firstName, String middleName, String lastName)
    {
        NameHelper.checkStringParam("firstName", firstName);
        NameHelper.checkStringParam("lastName", lastName);
        return new Name.NameBuilder()
                .setFirstName(firstName)
                .setMiddleName(middleName)
                .setLastName(lastName).getName();
    }

}
