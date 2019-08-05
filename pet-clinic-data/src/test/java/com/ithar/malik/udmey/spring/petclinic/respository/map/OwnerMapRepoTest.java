package com.ithar.malik.udmey.spring.petclinic.respository.map;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ithar.malik.udmey.spring.petclinic.model.Owner;
import com.ithar.malik.udmey.spring.petclinic.model.Pet;
import com.ithar.malik.udmey.spring.petclinic.model.PetType;
import com.ithar.malik.udmey.spring.petclinic.respository.PetRepository;
import com.ithar.malik.udmey.spring.petclinic.respository.PetTypeRepository;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OwnerMapRepoTest {

    private PetTypeRepository<PetType, Long> petTypeRepository;

    private PetRepository<Pet, Long> petRepository;

    private OwnerMapRepo ownerMapRepo;

    @BeforeEach
    private void setUp() {
        PetTypeRepository<PetType, Long> petTypeRepo = new PetTypeMapRepo();
        PetRepository<Pet, Long> petRepo = new PetMapRepo();
        ownerMapRepo = new OwnerMapRepo(petTypeRepo, petRepo);
    }

    @Test
    void findByLastName_Empty() {

        // Given

        // When
        Set<Owner> actualOwners = ownerMapRepo.findByLastName("Bob");

        // Then
        assertEquals(0, actualOwners.size());
    }

    @Test
    void findByLastName_NoMatches() {

        // Given
        String lastName = "Bond";

        Owner owner1 = new Owner();
        owner1.setLastName("Bob");

        Owner owner2 = new Owner();
        owner2.setLastName("Doe");

        Owner owner3 = new Owner();
        owner3.setLastName("Dillon");

        ownerMapRepo.save(owner1);
        ownerMapRepo.save(owner2);
        ownerMapRepo.save(owner3);

        // When
        Set<Owner> actualOwners = ownerMapRepo.findByLastName(lastName);

        // Then
        assertEquals(0, actualOwners.size());
    }

    @Test
    void findByLastName_OneMatch() {

        // Given
        String lastName = "Doe";

        Owner owner1 = new Owner();
        owner1.setLastName("Bob");

        Owner owner2 = new Owner();
        owner2.setLastName(lastName);

        Owner owner3 = new Owner();
        owner3.setLastName("Dillon");

        ownerMapRepo.save(owner1);
        ownerMapRepo.save(owner2);
        ownerMapRepo.save(owner3);

        // When
        Set<Owner> actualOwners = ownerMapRepo.findByLastName(lastName);

        // Then
        assertEquals(1, actualOwners.size());
        assertEquals(lastName, actualOwners.iterator().next().getLastName());
    }

    @Test
    void findByLastName_TwoMatches() {

        // Given
        String lastName = "Doe";

        Owner owner1 = new Owner();
        owner1.setLastName(lastName);

        Owner owner2 = new Owner();
        owner2.setLastName(lastName);

        Owner owner3 = new Owner();
        owner3.setLastName("Dillon");

        ownerMapRepo.save(owner1);
        ownerMapRepo.save(owner2);
        ownerMapRepo.save(owner3);

        // When
        Set<Owner> actualOwners = ownerMapRepo.findByLastName(lastName);

        // Then
        assertEquals(2, actualOwners.size());
    }


    @Test
    void findByLastNameLike() {

        // Given
        String lastName = "Doe";

        Owner owner1 = new Owner();
        owner1.setLastName("Doe A");

        Owner owner2 = new Owner();
        owner2.setLastName("A doe");

        Owner owner3 = new Owner();
        owner3.setLastName("doe");

        ownerMapRepo.save(owner1);
        ownerMapRepo.save(owner2);
        ownerMapRepo.save(owner3);

        // When
        Set<Owner> actualOwners = ownerMapRepo.findByLastNameContainingIgnoreCase(lastName);

        // Then
        assertEquals(3, actualOwners.size());
    }

    @Test
    void save() {
    }
}