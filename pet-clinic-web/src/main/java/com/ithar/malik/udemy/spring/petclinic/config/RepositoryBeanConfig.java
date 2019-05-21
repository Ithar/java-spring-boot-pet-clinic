package com.ithar.malik.udemy.spring.petclinic.config;

import com.ithar.malik.udmey.spring.petclinic.respository.map.OwnerMapRepository;
import com.ithar.malik.udmey.spring.petclinic.respository.map.PetMapRepository;
import com.ithar.malik.udmey.spring.petclinic.respository.map.PetTypeMapRepository;
import com.ithar.malik.udmey.spring.petclinic.respository.map.VetMapRepository;
import com.ithar.malik.udmey.spring.petclinic.respository.map.VetSpecialtyMapRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryBeanConfig {

    // Repositories
    @Bean
    public OwnerMapRepository getOwnerMapRepository() {
        return new OwnerMapRepository();
    }

    @Bean
    public VetMapRepository getVetMapRepository() {
        return new VetMapRepository();
    }

    @Bean
    public PetMapRepository getPetMapRepository() {
        return new PetMapRepository();
    }

    @Bean
    public PetTypeMapRepository getPetTypeRepository() {
        return new PetTypeMapRepository();
    }

    @Bean
    public VetSpecialtyMapRepository getVetSpecialtyRepository() {
        return new VetSpecialtyMapRepository();
    }

}
