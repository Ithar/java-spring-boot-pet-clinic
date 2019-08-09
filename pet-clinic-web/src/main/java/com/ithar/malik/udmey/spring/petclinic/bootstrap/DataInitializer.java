package com.ithar.malik.udmey.spring.petclinic.bootstrap;

import com.ithar.malik.udmey.spring.petclinic.model.Address;
import com.ithar.malik.udmey.spring.petclinic.model.Owner;
import com.ithar.malik.udmey.spring.petclinic.model.Pet;
import com.ithar.malik.udmey.spring.petclinic.model.PetType;
import com.ithar.malik.udmey.spring.petclinic.model.Specialty;
import com.ithar.malik.udmey.spring.petclinic.model.Vet;
import com.ithar.malik.udmey.spring.petclinic.model.Visit;
import com.ithar.malik.udmey.spring.petclinic.service.OwnerService;
import com.ithar.malik.udmey.spring.petclinic.service.PetTypeService;
import com.ithar.malik.udmey.spring.petclinic.service.VetService;
import com.ithar.malik.udmey.spring.petclinic.service.VetSpecialtyService;
import com.ithar.malik.udmey.spring.petclinic.service.VisitService;
import java.time.LocalDate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DataInitializer implements CommandLineRunner {

    private PetType dogPetType;
    private PetType catPetType;

    private Specialty radiologySpecialty;
    private Specialty surgerySpecialty;
    private Specialty dentistrySpecialty;

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final VetSpecialtyService vetSpecialtyService;
    private final VisitService visitService;

    public DataInitializer(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
        VetSpecialtyService vetSpecialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.vetSpecialtyService = vetSpecialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) {

        if (!isDataLoaded()) {
            loadData();
        }
    }

    private boolean isDataLoaded() {
        return !ownerService.findAll().isEmpty();
    }

    private void loadData() {

        // Set Pet Types
        setPetTypes();

        // Owner [Michael]

        Pet rockyDog = new Pet();
        rockyDog.setName("Rocky");
        rockyDog.setPetType(dogPetType);
        rockyDog.setBirthDate(LocalDate.of(2007, 5, 26));

        Address address1 = Address.builder().line1("123 Brick Lane").city("New York").telephone("07807787878").build();

        Owner owner1 = new Owner(); // TODO [IM 19-07-28] - Implement builder pattern
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress(address1);
        owner1.getPets().add(rockyDog);
        rockyDog.setOwner(owner1);

        // Owner [Fiona]
        Pet kittyCat = new Pet();
        kittyCat.setName("Justin");
        kittyCat.setPetType(catPetType);
        kittyCat.setBirthDate(LocalDate.of(2001, 11, 12));

        Address address2 = Address.builder().line1("1 Wall Street").city("New York").telephone("07899645724").build();

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress(address2);
        owner2.getPets().add(kittyCat);
        kittyCat.setOwner(owner2);

        ownerService.save(owner1);
        ownerService.save(owner2);

        // Vets Specialties
        setUpVetSpecialties();

        // Vets
        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add(radiologySpecialty);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialties().add(surgerySpecialty);
        vet2.getSpecialties().add(dentistrySpecialty);

        vetService.save(vet1);
        vetService.save(vet2);

        // Visits
        Visit visit = new Visit();
        visit.setPet(rockyDog);
        visit.setDescription("Hair loss");
        visit.setDate(LocalDate.now());

        visitService.save(visit);

        log.info("\n==========================================================");
        log.info("Loaded owners ... \t[" + ownerService.findAll().size() + "]");
        log.info("Loaded vets ... \t\t[" + vetService.findAll().size() + "]");
        log.info("Loaded visits ... \t[" + visitService.findAll().size() + "]");
        log.info("\n==========================================================");
    }

    private void setPetTypes() {

        PetType dogType = PetType.builder().build();
        dogType.setName("Dog");

        PetType catType = PetType.builder().build();
        catType.setName("Cat");

        this.dogPetType = petTypeService.save(dogType);
        this.catPetType = petTypeService.save(catType);
    }

    private void setUpVetSpecialties() {
        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");

        this.radiologySpecialty = vetSpecialtyService.save(radiology);
        this.surgerySpecialty = vetSpecialtyService.save(surgery);
        this.dentistrySpecialty = vetSpecialtyService.save(dentistry);
    }
}
