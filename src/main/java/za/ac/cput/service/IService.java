package za.ac.cput.service;
/*
 IService.java
 Interface for the services
 Author: Mogamad Githr Parker (220408025)
 Date: 18/06/2022
 */

import java.util.Optional;

public interface IService <T, ID>{
    T save(T t);
    Optional<T> read(ID id);
    void delete(T t);
}
