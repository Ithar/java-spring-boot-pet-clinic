package com.ithar.malik.udmey.spring.petclinic.config;

import com.ithar.malik.udmey.spring.petclinic.respository.OwnerRepository;
import com.ithar.malik.udmey.spring.petclinic.respository.PetRepository;
import com.ithar.malik.udmey.spring.petclinic.respository.PetTypeRepository;
import com.ithar.malik.udmey.spring.petclinic.respository.SpecialtyRepository;
import com.ithar.malik.udmey.spring.petclinic.respository.VetRepository;
import com.ithar.malik.udmey.spring.petclinic.respository.jpa.OwnerJPARepo;
import com.ithar.malik.udmey.spring.petclinic.respository.jpa.PetJPARepo;
import com.ithar.malik.udmey.spring.petclinic.respository.jpa.PetTypeJPARepo;
import com.ithar.malik.udmey.spring.petclinic.respository.jpa.SpecialtyJPARepo;
import com.ithar.malik.udmey.spring.petclinic.respository.jpa.VetJPARepo;
import com.ithar.malik.udmey.spring.petclinic.respository.jpa.VisitJPARepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryJPAConfig {

    private final OwnerJPARepo ownerJPARepo;
    private final PetJPARepo petJPARepo;
    private final PetTypeJPARepo petTypeJPARepo;
    private final SpecialtyJPARepo specialtyJPARepo;
    private final VetJPARepo vetJPARepo;
    private final VisitJPARepo visitJPARepo;

    public RepositoryJPAConfig(OwnerJPARepo ownerJPARepo, PetJPARepo petJPARepo, PetTypeJPARepo petTypeJPARepo,
        SpecialtyJPARepo specialtyJPARepo, VetJPARepo vetJPARepo, VisitJPARepo visitJPARepo) {
        this.ownerJPARepo = ownerJPARepo;
        this.petJPARepo = petJPARepo;
        this.petTypeJPARepo = petTypeJPARepo;
        this.specialtyJPARepo = specialtyJPARepo;
        this.vetJPARepo = vetJPARepo;
        this.visitJPARepo = visitJPARepo;
    }

    // Repositories
    @Bean
    public OwnerRepository getOwnerRepository() {
        return ownerJPARepo;
    }

    @Bean
    public VetRepository getVetRepository() {
        return vetJPARepo;
    }

    @Bean
    public PetRepository getPetRepository() {
        return petJPARepo;
    }

    @Bean
    public PetTypeRepository getPetTypeRepository() {
        return petTypeJPARepo;
    }

    @Bean
    public SpecialtyRepository getSpecialtyRepository() {
        return specialtyJPARepo;
    }

    @Bean
    public VisitJPARepo getVisitRepository() {
        return visitJPARepo;
    }
}
