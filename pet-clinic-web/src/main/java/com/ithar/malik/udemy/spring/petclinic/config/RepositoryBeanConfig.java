package com.ithar.malik.udemy.spring.petclinic.config;

import com.ithar.malik.udmey.spring.petclinic.respository.OwnerMapRepository;
import com.ithar.malik.udmey.spring.petclinic.respository.PetMapRepository;
import com.ithar.malik.udmey.spring.petclinic.respository.VetMapRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
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

}
