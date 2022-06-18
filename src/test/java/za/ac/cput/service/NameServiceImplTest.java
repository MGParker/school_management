package za.ac.cput.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import za.ac.cput.factory.NameFactory;
import za.ac.cput.domain.Name;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Name.java
 * entity for the Name
 * Author: Benelzane Kholani (218257465)
 * Date: 17 June 2022
 *
 */

class NameServiceImplTest {

    private Name name;
    private Name name2;
    private NameServiceImpl nameService;

    @BeforeEach
    void setUp() {
        this.name  = NameFactory.getName("Josh", "Miguel", "Hendrikson");
        this.name2 = NameFactory.getName("Ernest", "Caesar", "Ally");
        nameService = NameServiceImpl.getService();
    }

    @Test
    void testSave() {
        assertEquals(this.nameService.save(this.name), this.name);
    }

    @Test
    void testRead() {
        assertEquals(this.nameService.read(new Name.NameId(this.name.getFirstName(), this.name.getMiddleName(),
                this.name.getLastName())), this.name);
    }

    @Test
    void delete() {
//        assertTrue(this.nameService.delete(this.name));
    }

    @Test
    void getAll() {
        assertTrue(this.nameService.getAll().contains(this.name));
    }
}