package com.ithar.malik.udmey.spring.petclinic.service;

import com.ithar.malik.udmey.spring.petclinic.model.Pet;
import java.util.Set;

public interface PetService {

    Pet find(Long id);

    Set<Pet> findAll();

    Pet save(Pet pet);

}
