package com.ithar.malik.udmey.spring.petclinic.config;

import com.ithar.malik.udmey.spring.petclinic.model.Owner;
import com.ithar.malik.udmey.spring.petclinic.model.Pet;
import com.ithar.malik.udmey.spring.petclinic.model.PetType;
import com.ithar.malik.udmey.spring.petclinic.model.Specialty;
import com.ithar.malik.udmey.spring.petclinic.model.Vet;
import com.ithar.malik.udmey.spring.petclinic.model.Visit;
import com.ithar.malik.udmey.spring.petclinic.respository.OwnerRepository;
import com.ithar.malik.udmey.spring.petclinic.respository.PetRepository;
import com.ithar.malik.udmey.spring.petclinic.respository.PetTypeRepository;
import com.ithar.malik.udmey.spring.petclinic.respository.SpecialtyRepository;
import com.ithar.malik.udmey.spring.petclinic.respository.VetRepository;
import com.ithar.malik.udmey.spring.petclinic.respository.VisitRepository;
import com.ithar.malik.udmey.spring.petclinic.respository.map.OwnerMapRepo;
import com.ithar.malik.udmey.spring.petclinic.respository.map.PetMapRepo;
import com.ithar.malik.udmey.spring.petclinic.respository.map.PetTypeMapRepo;
import com.ithar.malik.udmey.spring.petclinic.respository.map.SpecialtyMapRepo;
import com.ithar.malik.udmey.spring.petclinic.respository.map.VetMapRepo;
import com.ithar.malik.udmey.spring.petclinic.respository.map.VisitMapRepo;
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
import com.ithar.malik.udmey.spring.petclinic.service.VisitService;
import com.ithar.malik.udmey.spring.petclinic.service.VisitServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("map")
@Configuration
public class MapBeanConfig {

    // Repositories
    @Bean
    public OwnerRepository<Owner, Long> getOwnerRepository() {
        return new OwnerMapRepo(getPetTypeRepository(), getPetRepository());
    }

    @Bean
    public VetRepository<Vet, Long> getVetRepository() {
        return new VetMapRepo();
    }

    @Bean
    public PetRepository<Pet, Long> getPetRepository() {
        return new PetMapRepo();
    }

    @Bean
    public PetTypeRepository<PetType, Long> getPetTypeRepository() {
        return new PetTypeMapRepo();
    }

    @Bean
    public SpecialtyRepository<Specialty, Long> getSpecialtyRepository() {
        return new SpecialtyMapRepo();
    }

    @Bean
    public VisitRepository<Visit, Long> getVisitRepository() {
        return new VisitMapRepo();
    }

    // Services
    @Bean
    public OwnerService getOwnerService() {
        return new OwnerServiceImpl(getOwnerRepository());
    }

    @Bean
    public VetService getVetService() {
        return new VetServiceImpl(getVetRepository(), getSpecialtyRepository());
    }

    @Bean
    public PetService getPetService() {
        return new PetServiceImpl(getPetRepository());
    }

    @Bean
    public PetTypeService getPetTypeService() {
        return new PetTypeServiceImpl(getPetTypeRepository());
    }

    @Bean
    public VetSpecialtyService getVetSpecialtyService() {
        return new VetSpecialtyServiceImpl(getSpecialtyRepository());
    }

    @Bean
    public VisitService getVisitService() {
        return new VisitServiceImpl(getVisitRepository());
    }
}
