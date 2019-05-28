package com.ithar.malik.udmey.spring.petclinic.respository.jpa;

import com.ithar.malik.udmey.spring.petclinic.model.Visit;
import com.ithar.malik.udmey.spring.petclinic.respository.VisitRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitJPARepo extends CrudRepository<Visit, Long>, VisitRepository<Visit, Long> {

}
