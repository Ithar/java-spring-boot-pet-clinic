package com.ithar.malik.udmey.spring.petclinic.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.ithar.malik.udmey.spring.petclinic.model.Owner;
import com.ithar.malik.udmey.spring.petclinic.model.Pet;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OwnerServiceMapImplTest {

    private OwnerServiceImpl ownerService;

    @BeforeEach
    void setUp() {
        //this.ownerService = new OwnerServiceImpl(new OwnerMapRepo(new PetTypeMapRepo(), new PetMapRepo()));
    }

    @Test
    void findById() {

        // Given
        Long ownerId = 123L;
        Owner owner1 = new Owner();
        owner1.setId(ownerId);
        ownerService.save(owner1);

        // When
        Owner owner = ownerService.findById(ownerId);

        // Then
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void findAll() {

        // Given
        Owner owner1 = new Owner();
        owner1.setId(1L);

        Owner owner2 = new Owner();
        owner2.setId(2L);

        ownerService.save(owner1);
        ownerService.save(owner2);

        // When
        Set<Owner> owners = ownerService.findAll();

        // Then
        assertEquals(2, owners.size());
    }

    @Test
    void save() {

        // Given
        Pet pet1 = new Pet();
        pet1.setId(1L);
        pet1.setName("Tom");

        Pet pet2 = new Pet();
        pet2.setId(2L);
        pet2.setName("Jerry");

        Set<Pet> pets = new HashSet<>();
        pets.add(pet1);
        pets.add(pet2);

        Long ownerId = 123L;
        String firstName = "Karl";
        String lastName = "Marx";

        Owner owner = new Owner();
        owner.setId(ownerId);
        owner.setFirstName(firstName);
        owner.setLastName(lastName);
        owner.setPets(pets);

        // When
        owner = ownerService.save(owner);

        // Then
        assertEquals(ownerId, owner.getId());
        assertEquals(firstName, owner.getFirstName());
        assertEquals(lastName, owner.getLastName());
        assertEquals(2, owner.getPets().size());
    }

    @Test
    void save_ExistingUser() {

        // Given
        Long ownerId = 123L;
        Owner owner = new Owner();
        owner.setId(ownerId);
        owner.setFirstName("Karl");
        ownerService.save(owner);
        String updatedFirstName = "Tom";
        owner.setFirstName(updatedFirstName);

        // When
        owner = ownerService.save(owner);

        // Then
        assertEquals(updatedFirstName, owner.getFirstName());
    }

    @Test
    void save_WithNoId() {

        // Given
        Owner owner = new Owner();
        ownerService.save(owner);

        // When
        owner = ownerService.save(owner);

        // Then
        assertNotNull(owner.getId());
    }

    @Test
    void deleteById() {

        // Given
        Long ownerId = 123L;
        Owner owner = new Owner();
        owner.setId(ownerId);
        ownerService.save(owner);

        // When
        ownerService.deleteById(ownerId);

        // Then
        Set<Owner> owners = ownerService.findAll();
        assertEquals(0, owners.size());
    }

    @Test
    void delete() {

        // Given
        Long ownerId = 123L;
        Owner owner = new Owner();
        owner.setId(ownerId);
        ownerService.save(owner);

        // When
        ownerService.delete(owner);

        // Then
        Set<Owner> owners = ownerService.findAll();
        assertEquals(0, owners.size());
    }

    @Test
    void findByLastNam() {

        // Given
        Long ownerId = 123L;
        String lastName = "Marx";

        Owner owner = new Owner();
        owner.setLastName(lastName);
        ownerService.save(owner);

        // When
        Set<Owner> owners = ownerService.findByLastName(lastName);

        // Then
        assertEquals(1, owners.size());
    }

    @Test
    void findByLastName_None() {

        // Given
        Long ownerId = 123L;
        String firstName = "Karl";
        String lastName = "Marx";

        Owner owner = new Owner();
        owner.setId(ownerId);
        owner.setFirstName(firstName);
        owner.setLastName(lastName);
        ownerService.save(owner);

        // When
        Set<Owner> owners = ownerService.findByLastName("Dummy");

        // Then
        assertEquals(0, owners.size());
    }
}