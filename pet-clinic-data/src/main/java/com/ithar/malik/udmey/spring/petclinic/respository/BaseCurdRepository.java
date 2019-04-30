package com.ithar.malik.udmey.spring.petclinic.respository;

import java.util.Set;

public interface BaseCurdRepository<T, ID> {

    T findById(ID id);

    Set<T> findAll();

    T save(ID id, T object);

    void deleteById(ID id);

    void delete(T object);

}
