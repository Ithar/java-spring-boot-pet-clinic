package com.ithar.malik.udemy.spring.petclinic.config;

import com.ithar.malik.udmey.spring.petclinic.service.OwnerService;
import com.ithar.malik.udmey.spring.petclinic.service.PetService;
import com.ithar.malik.udmey.spring.petclinic.service.VetService;
import com.ithar.malik.udmey.spring.petclinic.service.map.OwnerServiceMapImpl;
import com.ithar.malik.udmey.spring.petclinic.service.map.PetServiceMapImpl;
import com.ithar.malik.udmey.spring.petclinic.service.map.VetServiceMapImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ServiceBeanConfig {

    private RepositoryBeanConfig repository = new RepositoryBeanConfig();

    // Services
    @Bean
    public OwnerService getOwnerService() {
        return new OwnerServiceMapImpl(repository.getOwnerMapRepository());
    }

    @Bean
    public VetService getVetService() {
        return new VetServiceMapImpl(repository.getVetMapRepository());
    }

    @Bean
    public PetService getPetService() {
        return new PetServiceMapImpl(repository.getPetMapRepository());
    }


}
