package com.ithar.malik.udmey.spring.petclinic.service;

import com.ithar.malik.udmey.spring.petclinic.model.Owner;
import java.util.Set;

public interface OwnerService {

    Owner find(Long id);

    Set<Owner> findAll();

    Owner save(Owner owner);
}
