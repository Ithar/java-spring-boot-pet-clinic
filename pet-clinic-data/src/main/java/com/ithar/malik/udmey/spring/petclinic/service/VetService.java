package com.ithar.malik.udmey.spring.petclinic.service;

import com.ithar.malik.udmey.spring.petclinic.model.Vet;
import java.util.Set;

public interface VetService {

    Vet find(Long id);

    Set<Vet> findAll();

    Vet save(Vet vet);
}
