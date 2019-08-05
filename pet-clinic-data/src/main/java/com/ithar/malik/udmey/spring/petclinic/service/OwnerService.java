package com.ithar.malik.udmey.spring.petclinic.service;

import com.ithar.malik.udmey.spring.petclinic.model.Owner;
import java.util.Set;

public interface OwnerService extends BaseCrudService<Owner, Long> {

    Set<Owner> findByLastName(String lastName);

    Set<Owner> findByLastNameLike(String lastName);
}
