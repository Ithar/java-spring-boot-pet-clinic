package com.ithar.malik.udemy.spring.petclinic.bootstrap;

import com.ithar.malik.udmey.spring.petclinic.model.Address;
import com.ithar.malik.udmey.spring.petclinic.model.Owner;
import com.ithar.malik.udmey.spring.petclinic.model.Pet;
import com.ithar.malik.udmey.spring.petclinic.model.PetType;
import com.ithar.malik.udmey.spring.petclinic.model.Vet;
import com.ithar.malik.udmey.spring.petclinic.service.OwnerService;
import com.ithar.malik.udmey.spring.petclinic.service.PetTypeService;
import com.ithar.malik.udmey.spring.petclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataInitializer(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dogType = new PetType();
        dogType.setName("Dog");

        PetType catType = new PetType();
        catType.setName("Cat");

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
        justin.setName("justin");
        justin.setPetType(savedCatType);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress(address2);
        owner2.getPets().add(justin);

        ownerService.save(owner1);
        ownerService.save(owner2);

        System.out.println("Loaded owners ... ["+ownerService.findAll().size()+"]");

        // Vets
        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

         vetService.save(vet1);
         vetService.save(vet2);

        System.out.println("Loaded vets ... ["+vetService.findAll().size()+"]");
    }
}
