package com.ithar.malik.udmey.spring.petclinic.respository.jpa;

import com.ithar.malik.udmey.spring.petclinic.model.Owner;
import com.ithar.malik.udmey.spring.petclinic.respository.OwnerRepository;
import java.util.Set;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerJPARepo extends CrudRepository<Owner, Long>, OwnerRepository<Owner, Long> {

    Set<Owner> findByLastName(String lastName);

}
