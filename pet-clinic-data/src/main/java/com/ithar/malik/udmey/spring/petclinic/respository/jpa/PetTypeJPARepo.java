package com.ithar.malik.udmey.spring.petclinic.respository.jpa;

import com.ithar.malik.udmey.spring.petclinic.model.PetType;
import com.ithar.malik.udmey.spring.petclinic.respository.PetTypeRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetTypeJPARepo extends CrudRepository<PetType, Long>, PetTypeRepository<PetType, Long> {

}
