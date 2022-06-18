package za.ac.cput.repository;

import za.ac.cput.factory.NameFactory;
import za.ac.cput.domain.Name;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Name.java
 * entity for the Name
 * Author: Benelzane Kholani (218257465)
 * Date: 17 June 2022
 *
 */

class NameRepositoryImplTest {

    private Name name;
    private Name name2;
    private NameRepositoryImpl nameRepository;
    private Name.NameID nameId;

    @BeforeEach
    void setUp() {
        this.name  = NameFactory.getName("Josh", "Miguel", "Hendrikson");
        this.name2 = NameFactory.getName("Ernest", "Caesar", "Ally");
        nameRepository = NameRepositoryImpl.nameRepository();
    }

    @Test
    void testSave() {

        assertAll(
                ()->assertSame(this.name, nameRepository.save(this.name)),
                ()->assertSame(this.name2, nameRepository.save(this.name2))
        );
    }

    @Test
    void testRead() {
        assertEquals(this.name, nameRepository.read(new Name.NameID(this.name.getFirstName(), this.name.getMiddleName(), this.name.getLastName())));
    }

    @Test
    void testDelete() {
        assertTrue(nameRepository.delete(this.name));
    }

    @Test
    void testGetAll() {
        assertTrue(nameRepository.getAll().contains(this.name2));
    }
}