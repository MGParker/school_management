package za.ac.cput.service;
import za.ac.cput.repository.NameRepositoryImpl;
import za.ac.cput.domain.Name;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
 * Name.java
 * entity for the Name
 * Author: Benelzane Kholani (218257465)
 * Date: 17 June 2022
 *
 */

public class NameServiceImpl implements INameService {

    private static NameRepositoryImpl repository = null;
    private static NameServiceImpl SERVICE;

    private NameServiceImpl(){
        this.repository = NameRepositoryImpl.nameRepository();
    }

    public static NameServiceImpl getService(){
        if(SERVICE == null){
            SERVICE = new NameServiceImpl();
        }
        return SERVICE;
    }

    @Override
    public Name save(Name name) {
        return this.repository.save(name);
    }

    @Override
    public Optional<Name> read(Name.NameId nameId) {
        return this.repository.read(nameId);
    }

    @Override
    public void delete(Name name) {
         this.repository.delete(name);
    }

    @Override
    public List<Name> getAll() {
        return this.repository.getAll();
    }

}
