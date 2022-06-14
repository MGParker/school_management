package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import za.ac.cput.domain.Name;

/*
 * Name.java
 * entity for the Name
 * Author: Benelzane Kholani (218257465)
 * Date: 18 June 2022
 *
 */

class NameFactoryTest {

    private Name name;
    private Name name2;

    @BeforeEach
    void setUp() {
        name  = NameFactory.getName("Cole", "Bernard", "Woods");
        name2 = NameFactory.getName("Maven", "Gerad", "");
    }

    @Test
    public void testEquality(){
        //test instance variables are all set
        assertAll("NameFactory",
                ()->assertEquals("Cole", name.getFirstName()),
                ()->assertEquals("Bernard", name.getMiddleName()),
                ()->assertEquals("Woods", name.getLastName()));//test success
    }//end of testEquality method

    @Test
    public void testIdentity(){
        assertSame(name, name2);//failed test, objects are not the same
    }//end of testIdentity method

    @Test
    public void testNull(){

        assertNotNull(name);//object is not null
    }

}