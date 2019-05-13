package com.ithar.malik.udemy.spring.petclinic.config;

import com.ithar.malik.udmey.spring.petclinic.service.OwnerService;
import com.ithar.malik.udmey.spring.petclinic.service.PetService;
import com.ithar.malik.udmey.spring.petclinic.service.PetTypeService;
import com.ithar.malik.udmey.spring.petclinic.service.VetService;
import com.ithar.malik.udmey.spring.petclinic.service.VetSpecialtyService;
import com.ithar.malik.udmey.spring.petclinic.service.VetSpecialtyServiceImpl;
import com.ithar.malik.udmey.spring.petclinic.service.map.OwnerServiceMapImpl;
import com.ithar.malik.udmey.spring.petclinic.service.map.PetServiceMapImpl;
import com.ithar.malik.udmey.spring.petclinic.service.map.PetTypeServiceMapImpl;
import com.ithar.malik.udmey.spring.petclinic.service.map.VetServiceMapImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ServiceBeanConfig {

    private RepositoryBeanConfig repositories = new RepositoryBeanConfig();

    // Services
    @Bean
    public OwnerService getOwnerService() {
        return new OwnerServiceMapImpl(repositories.getOwnerMapRepository(), getPetTypeService(), getPetService());
    }

    @Bean
    public VetService getVetService() {
        return new VetServiceMapImpl(repositories.getVetMapRepository());
    }

    @Bean
    public PetService getPetService() {
        return new PetServiceMapImpl(repositories.getPetMapRepository());
    }

    @Bean
    public PetTypeService getPetTypeService() {
        return new PetTypeServiceMapImpl(repositories.getPetTypeRepository());
    }

    @Bean
    public VetSpecialtyService getVetSpecialtyService() {
        return new VetSpecialtyServiceImpl(repositories.getVetSpecialtyRepository());
    }

}
