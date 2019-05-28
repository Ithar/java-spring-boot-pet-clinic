package com.ithar.malik.udmey.spring.petclinic.respository.jpa;

import com.ithar.malik.udmey.spring.petclinic.model.Vet;
import com.ithar.malik.udmey.spring.petclinic.respository.VetRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetJPARepo extends CrudRepository<Vet, Long>, VetRepository<Vet, Long> {

}
