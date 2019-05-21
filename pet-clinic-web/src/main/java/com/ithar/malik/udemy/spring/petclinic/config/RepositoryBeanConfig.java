package com.ithar.malik.udemy.spring.petclinic.config;

import com.ithar.malik.udmey.spring.petclinic.respository.map.OwnerMapRepo;
import com.ithar.malik.udmey.spring.petclinic.respository.map.PetMapRepo;
import com.ithar.malik.udmey.spring.petclinic.respository.map.PetTypeMapRepo;
import com.ithar.malik.udmey.spring.petclinic.respository.map.VetMapRepo;
import com.ithar.malik.udmey.spring.petclinic.respository.map.VetSpecialtyMapRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryBeanConfig {

    // Repositories
    @Bean
    public OwnerMapRepo getOwnerMapRepository() {
        return new OwnerMapRepo();
    }

    @Bean
    public VetMapRepo getVetMapRepository() {
        return new VetMapRepo();
    }

    @Bean
    public PetMapRepo getPetMapRepository() {
        return new PetMapRepo();
    }

    @Bean
    public PetTypeMapRepo getPetTypeRepository() {
        return new PetTypeMapRepo();
    }

    @Bean
    public VetSpecialtyMapRepo getVetSpecialtyRepository() {
        return new VetSpecialtyMapRepo();
    }

}
