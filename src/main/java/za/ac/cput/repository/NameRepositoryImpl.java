package za.ac.cput.repository;

import za.ac.cput.domain.Name;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

/*
 * Name.java
 * entity for the Name
 * Author: Benelzane Kholani (218257465)
 * Date: 16 June 2022
 *
 */
public class NameRepositoryImpl implements INameRepository<Name, Name.NameID>{

    private final List<Name> nameList;
    private static NameRepositoryImpl nameRepository;

    private NameRepositoryImpl()
    {
        this.nameList = new ArrayList<>();
    }

    public static NameRepositoryImpl nameRepository(){
        if (nameRepository == null) {
            nameRepository = new NameRepositoryImpl();
        }
        return nameRepository;
    }

    public Name save(Name name)
    {
        Name.NameID nameId = new Name.NameID(name.getFirstName(), name.getMiddleName(), name.getLastName());
        Optional<Name> read = read(nameId);
        if (read.isPresent()){
            delete(read.get());
        }
        this.nameList.add(name);
        return name;
    }

    public Optional<Name> read(Name.NameID nameId) {
        return this.nameList.stream()
                .filter(e -> e.getFirstName().equalsIgnoreCase(nameId.getFirstName()))
                .filter(e -> e.getMiddleName().equalsIgnoreCase(nameId.getMiddleName()))
                .filter(e -> e.getLastName().equalsIgnoreCase(nameId.getLastName()))
                .findFirst();
    }

    public boolean delete(Name name){
       return  this.nameList.remove(name);
    }

    public List<Name> getAll(){
        return this.nameList;
    }

}