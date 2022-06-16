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
public class NameRepository  implements INameRepository<Name>{

    private final List<Name> nameList;
    private static NameRepository nameRepository;

    private NameRepository()
    {
        this.nameList = new ArrayList<>();
    }

    public static NameRepository nameRepository(){
        if (nameRepository == null) {
            nameRepository = new NameRepository();
        }
        return nameRepository;
    }

    public Name save(Name name)
    {
        Optional<Name> read = read(name);
        if (read.isPresent()){
            delete(read.get());
        }
        this.nameList.add(name);
        return name;
    }

    public Optional<Name> read(Name name){

        return this.nameList.stream().filter(c -> c.equals(name))
                .findAny();
    }

    public void delete(Name name){
        this.nameList.remove(name);
    }

    public List<Name> getAll(){
        return this.nameList;
    }


}
