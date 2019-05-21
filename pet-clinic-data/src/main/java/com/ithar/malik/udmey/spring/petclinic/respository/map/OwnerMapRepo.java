package com.ithar.malik.udmey.spring.petclinic.respository.map;

import com.ithar.malik.udmey.spring.petclinic.model.Owner;
import com.ithar.malik.udmey.spring.petclinic.respository.OwnerRepository;
import java.util.Set;
import java.util.stream.Collectors;

public class OwnerMapRepo extends MapRepo<Owner, Long> implements OwnerRepository<Owner, Long> {

    @Override
    public Set<Owner> findByLastName(String lastName) {
        return
            findAll()
            .stream()
            .filter(owner -> lastName.equals(owner.getLastName()))
            .collect(Collectors.toSet());
    }
}
