package com.ithar.malik.udmey.spring.petclinic.bootstrap;

import com.ithar.malik.udmey.spring.petclinic.model.Address;
import com.ithar.malik.udmey.spring.petclinic.model.Owner;
import com.ithar.malik.udmey.spring.petclinic.model.Pet;
import com.ithar.malik.udmey.spring.petclinic.model.PetType;
import com.ithar.malik.udmey.spring.petclinic.model.Specialty;
import com.ithar.malik.udmey.spring.petclinic.model.Vet;
import com.ithar.malik.udmey.spring.petclinic.service.OwnerService;
import com.ithar.malik.udmey.spring.petclinic.service.PetTypeService;
import com.ithar.malik.udmey.spring.petclinic.service.VetService;
import com.ithar.malik.udmey.spring.petclinic.service.VetSpecialtyService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final VetSpecialtyService betSpecialtyService;

    public DataInitializer(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
        VetSpecialtyService betSpecialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.betSpecialtyService = betSpecialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        if (!isDataLoaded()) {
            loadData();
        }
    }

    private boolean isDataLoaded() {
        return !ownerService.findAll().isEmpty();
    }

    private void loadData() {
        PetType dogType = new PetType();
        dogType.setTypeName("Dog");

        PetType catType = new PetType();
        catType.setTypeName("Cat");

        PetType savedDogType = petTypeService.save(dogType);
        PetType savedCatType = petTypeService.save(catType);

        // Owners

        Address address1 = new Address("123 Brick Lane", "New York", "07807787878");
        Pet rosco = new Pet();
        rosco.setName("Rosco");
        rosco.setPetType(savedDogType);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress(address1);
        owner1.getPets().add(rosco);

        Address address2 = new Address("123 Brick Lane", "New York", "07807787878");
        Pet justin = new Pet();
        justin.setName("Justin");
        justin.setPetType(savedCatType);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress(address2);
        owner2.getPets().add(justin);

        ownerService.save(owner1);
        ownerService.save(owner2);

        // Vets Specialties
        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");

        Specialty savedRadiology = betSpecialtyService.save(radiology);
        Specialty savedSurgery  = betSpecialtyService.save(surgery);
        Specialty savedDentistry = betSpecialtyService.save(dentistry);

        // Vets
        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add(savedRadiology);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialties().add(savedSurgery);
        vet2.getSpecialties().add(savedDentistry);

        vetService.save(vet1);
        vetService.save(vet2);

        System.out.println("\n==========================================================");
        System.out.println("Loaded owners ... ["+ownerService.findAll().size()+"]");
        System.out.println("Loaded vets ... ["+vetService.findAll().size()+"]");
        System.out.println("==========================================================\n");
    }
}
