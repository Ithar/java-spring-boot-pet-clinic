package com.ithar.malik.udmey.spring.petclinic.respository;

import java.util.Optional;
import java.util.Set;

public interface BaseCurdRepository<T, ID> {

    Optional<T> findById(ID id);

    Set<T> findAll(); // TODO [IM 19-05-21] Make this Iterable<T>

    T save(T object);

    void deleteById(ID id);

    void delete(T object);

}
