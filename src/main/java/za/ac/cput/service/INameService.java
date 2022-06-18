package za.ac.cput.service;

import java.util.List;
import za.ac.cput.domain.Name;
/*
 * Name.java
 * entity for the Name
 * Author: Benelzane Kholani (218257465)
 * Date: 17 June 2022
 *
 */

public interface INameService extends IService<Name, Name.NameID>{
    List<Name> getAll();
}