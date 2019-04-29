package com.ithar.malik.udmey.spring.petclinic.service;

import java.util.Set;

public interface BaseCrudService<T, ID> {

    T findById(ID id);

    Set<T> findAll();

    T save(T object);

    void deleteById(ID id);

    void delete(T object);
}
