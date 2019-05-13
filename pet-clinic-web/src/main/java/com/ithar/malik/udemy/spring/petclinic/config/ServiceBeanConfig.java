package com.ithar.malik.udemy.spring.petclinic.config;

import com.ithar.malik.udmey.spring.petclinic.service.OwnerService;
import com.ithar.malik.udmey.spring.petclinic.service.OwnerServiceImpl;
import com.ithar.malik.udmey.spring.petclinic.service.PetService;
import com.ithar.malik.udmey.spring.petclinic.service.PetServiceImpl;
import com.ithar.malik.udmey.spring.petclinic.service.PetTypeService;
import com.ithar.malik.udmey.spring.petclinic.service.PetTypeServiceImpl;
import com.ithar.malik.udmey.spring.petclinic.service.VetService;
import com.ithar.malik.udmey.spring.petclinic.service.VetServiceImpl;
import com.ithar.malik.udmey.spring.petclinic.service.VetSpecialtyService;
import com.ithar.malik.udmey.spring.petclinic.service.VetSpecialtyServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ServiceBeanConfig {

    private RepositoryBeanConfig repositories = new RepositoryBeanConfig();

    // Services
    @Bean
    public OwnerService getOwnerService() {
        return new OwnerServiceImpl(repositories.getOwnerMapRepository(), getPetTypeService(), getPetService());
    }

    @Bean
    public VetService getVetService() {
        return new VetServiceImpl(repositories.getVetMapRepository());
    }

    @Bean
    public PetService getPetService() {
        return new PetServiceImpl(repositories.getPetMapRepository());
    }

    @Bean
    public PetTypeService getPetTypeService() {
        return new PetTypeServiceImpl(repositories.getPetTypeRepository());
    }

    @Bean
    public VetSpecialtyService getVetSpecialtyService() {
        return new VetSpecialtyServiceImpl(repositories.getVetSpecialtyRepository());
    }

}
