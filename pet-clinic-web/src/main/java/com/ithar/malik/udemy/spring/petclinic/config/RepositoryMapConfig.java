package com.ithar.malik.udemy.spring.petclinic.config;

import com.ithar.malik.udmey.spring.petclinic.respository.OwnerRepository;
import com.ithar.malik.udmey.spring.petclinic.respository.PetRepository;
import com.ithar.malik.udmey.spring.petclinic.respository.PetTypeRepository;
import com.ithar.malik.udmey.spring.petclinic.respository.SpecialtyRepository;
import com.ithar.malik.udmey.spring.petclinic.respository.map.OwnerMapRepo;
import com.ithar.malik.udmey.spring.petclinic.respository.map.PetMapRepo;
import com.ithar.malik.udmey.spring.petclinic.respository.map.PetTypeMapRepo;
import com.ithar.malik.udmey.spring.petclinic.respository.map.SpecialtyMapRepo;
import com.ithar.malik.udmey.spring.petclinic.respository.map.VetMapRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@Profile("map")
public class RepositoryMapConfig {

    // Repositories
    @Bean
    public OwnerRepository getOwnerRepository() {
        return new OwnerMapRepo();
    }

    @Bean
    public VetMapRepo getVetMapRepository() {
        return new VetMapRepo();
    }

    @Bean
    public PetRepository getPetRepository() {
        return new PetMapRepo();
    }

    @Bean
    public PetTypeRepository getPetTypeRepository() {
        return new PetTypeMapRepo();
    }

    @Bean
    public SpecialtyRepository getSpecialtyRepository() {
        return new SpecialtyMapRepo();
    }

}
