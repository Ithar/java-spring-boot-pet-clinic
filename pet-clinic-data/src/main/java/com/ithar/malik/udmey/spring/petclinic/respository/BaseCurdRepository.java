package com.ithar.malik.udmey.spring.petclinic.respository;

import java.util.Optional;

public interface BaseCurdRepository<T, ID> {

    Optional<T> findById(ID id);

    Iterable<T> findAll();

    T save(T object);

    void deleteById(ID id);

    void delete(T object);

}
