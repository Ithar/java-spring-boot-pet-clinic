package com.ithar.malik.udmey.spring.petclinic.respository.jpa;

import com.ithar.malik.udmey.spring.petclinic.model.Specialty;
import com.ithar.malik.udmey.spring.petclinic.respository.SpecialtyRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialtyJPARepo extends CrudRepository<Specialty, Long>, SpecialtyRepository<Specialty, Long> {

}
