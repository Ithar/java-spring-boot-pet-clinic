package com.ithar.malik.udmey.spring.petclinic.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.ithar.malik.udmey.spring.petclinic.mapper.OwnerMapperService;
import com.ithar.malik.udmey.spring.petclinic.model.Owner;
import com.ithar.malik.udmey.spring.petclinic.model.Pet;
import com.ithar.malik.udmey.spring.petclinic.respository.OwnerRepository;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OwnerServiceImplTest {

    @Mock
    private OwnerMapperService ownerMapperService;

    @Mock
    private OwnerRepository<Owner, Long> repository;

    @InjectMocks
    private OwnerServiceImpl service;

    @Test
    void addPet_OnePet() {

        // Given
        Pet pet1 = new Pet();

        Owner owner = new Owner();

        // When
        service.addPet(owner, pet1);

        // Then
        assertFalse(owner.getPets().isEmpty());
        assertEquals(1, owner.getPets().size());
    }

    @Test
    void addPet_TwoPets() {

        // Given
        Pet pet1 = new Pet();
        pet1.setName("Rolf");

        Pet pet2 = new Pet();
        pet2.setName("Ski");

        Owner owner = new Owner();

        // When
        service.addPet(owner, pet1);
        pet1.setId(1L); // TODO [IM 19-08-09] - Re-write hash method to allow for this case (i.e. without setting id here)
        service.addPet(owner, pet2);

        // Then
        assertFalse(owner.getPets().isEmpty());
        assertEquals(2, owner.getPets().size());
    }

    @Test
    void addPet_NewPetToExisting() {

        // Given
        Pet pet0 = new Pet();
        pet0.setId(1L);
        pet0.setName("Rocky");

        Pet pet1 = new Pet();
        pet1.setId(2L);
        pet1.setName("Ski");

        Pet pet2 = new Pet();
        pet2.setId(3L);
        pet2.setName("Rolf");

        Set<Pet> pets = new HashSet<>();
        pets.add(pet0);
        pets.add(pet1);
        pets.add(pet2);

        Owner owner = new Owner();
        owner.setPets(pets);

        Pet petNew = new Pet();
        petNew.setName("Mocha");

        // When
        service.addPet(owner, petNew);

        // Then
        assertFalse(owner.getPets().isEmpty());
        assertEquals(4, owner.getPets().size());
    }

    @Test
    void addPet_UpdatePetToExisting() {

        // Given
        Pet pet0 = new Pet();
        pet0.setId(1L);
        pet0.setName("Rocky");

        Pet pet1 = new Pet();
        pet1.setId(2L);
        pet1.setName("Ski");

        Pet pet2 = new Pet();
        pet2.setId(3L);
        pet2.setName("Rolf");

        Set<Pet> pets = new HashSet<>();
        pets.add(pet0);
        pets.add(pet1);
        pets.add(pet2);

        Owner owner = new Owner();
        owner.setPets(pets);

        pet1.setName("Ski updated");

        // When
        service.addPet(owner, pet1);

        // Then
        assertFalse(owner.getPets().isEmpty());
        assertEquals(3, owner.getPets().size());
    }

}