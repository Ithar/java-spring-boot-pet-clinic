package com.ithar.malik.udmey.spring.petclinic.respository.map;

import com.ithar.malik.udmey.spring.petclinic.model.Pet;
import com.ithar.malik.udmey.spring.petclinic.respository.PetRepository;

public class PetMapRepo extends MapRepo<Pet, Long> implements PetRepository<Pet, Long> {

}
