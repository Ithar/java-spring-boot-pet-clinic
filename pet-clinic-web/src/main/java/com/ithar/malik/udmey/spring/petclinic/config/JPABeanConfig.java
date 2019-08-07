package com.ithar.malik.udmey.spring.petclinic.config;

import com.ithar.malik.udmey.spring.petclinic.mapper.OwnerMapperService;
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

@Profile("jpa")
@Configuration
public class JPABeanConfig {

    private final OwnerRepository<Owner, Long> ownerRepository;
    private final VetRepository<Vet, Long> vetRepository;
    private final PetRepository<Pet, Long> petRepository;
    private final PetTypeRepository<PetType, Long> petTypeRepository;
    private final SpecialtyRepository<Specialty, Long> specialtyRepository;
    private final VisitRepository<Visit, Long> visitRepository;

    private final OwnerMapperService ownerMapperService;

    public JPABeanConfig(
        OwnerRepository<Owner, Long> ownerRepository,
        VetRepository<Vet, Long> vetRepository,
        PetRepository<Pet, Long> petRepository,
        PetTypeRepository<PetType, Long> petTypeRepository,
        SpecialtyRepository<Specialty, Long> specialtyRepository,
        VisitRepository<Visit, Long> visitRepository, OwnerMapperService ownerMapperService) {
        this.ownerRepository = ownerRepository;
        this.vetRepository = vetRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
        this.specialtyRepository = specialtyRepository;
        this.visitRepository = visitRepository;
        this.ownerMapperService = ownerMapperService;
    }

    // Services
    @Bean
    public OwnerService getOwnerService() {
        return new OwnerServiceImpl(ownerMapperService, ownerRepository);
    }

    @Bean
    public VetService getVetService() {
        return new VetServiceImpl(vetRepository, specialtyRepository);
    }

    @Bean
    public PetService getPetService() {
        return new PetServiceImpl(petRepository);
    }

    @Bean
    public PetTypeService getPetTypeService() {
        return new PetTypeServiceImpl(petTypeRepository);
    }

    @Bean
    public VetSpecialtyService getVetSpecialtyService() {
        return new VetSpecialtyServiceImpl(specialtyRepository);
    }

    @Bean
    public VisitService getVisitRepository() {
        return new VisitServiceImpl(visitRepository);
    }
}
