package com.ithar.malik.udmey.spring.petclinic.respository.jpa;

import com.ithar.malik.udmey.spring.petclinic.model.Pet;
import com.ithar.malik.udmey.spring.petclinic.respository.PetRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetJPARepo extends CrudRepository<Pet, Long>, PetRepository<Pet, Long> {

}
