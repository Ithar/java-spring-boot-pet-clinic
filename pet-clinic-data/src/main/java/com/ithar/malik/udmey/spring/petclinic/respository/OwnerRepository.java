package com.ithar.malik.udmey.spring.petclinic.respository;

import java.util.Set;

public interface OwnerRepository<T, ID> extends BaseCurdRepository<T, ID> {

    Set<T> findByLastName(String lastName);

    Set<T> findByLastNameContainingIgnoreCase(String lastName);
}
