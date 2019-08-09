package com.ithar.malik.udmey.spring.petclinic.service;

import com.ithar.malik.udmey.spring.petclinic.dto.OwnerDTO;
import com.ithar.malik.udmey.spring.petclinic.model.Owner;
import com.ithar.malik.udmey.spring.petclinic.model.Pet;
import java.util.Optional;
import java.util.Set;

public interface OwnerService extends BaseCrudService<Owner, Long> {

    Set<Owner> findByLastName(String lastName);

    Set<Owner> findByLastNameLike(String lastName);

    Owner save(OwnerDTO ownerDTO);

    OwnerDTO mapToDTO(Owner owner);

    Optional<Pet> getPetByOwner(Owner owner, long petId);

    void addPet(Owner owner, Pet pet);
}
