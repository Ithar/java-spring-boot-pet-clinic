package com.ithar.malik.udmey.spring.petclinic.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.ithar.malik.udmey.spring.petclinic.model.Owner;
import com.ithar.malik.udmey.spring.petclinic.respository.OwnerRepository;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OwnerServiceJPAImplTest {

    @Mock
    private OwnerRepository<Owner, Long> ownerRepository;

    @InjectMocks
    private OwnerServiceImpl service;

    @Test
    void findById() {

        // Given
        Long id = 123L;
        Owner owner = new Owner();
        owner.setId(id);

        Optional<Owner> ownerOptional = Optional.of(owner);
        when(ownerRepository.findById(anyLong())).thenReturn(ownerOptional);

        // When
        Owner actualOwner = service.findById(id);

        // Then
        assertNotNull(actualOwner);
        assertEquals(id, actualOwner.getId());
    }

    @Test
    void findAll() {

        // Given
        Owner owner1 = new Owner();
        owner1.setId(1L);

        Owner owner2 = new Owner();
        owner2.setId(2L);

        Set<Owner> owners = new HashSet<>();
        owners.add(owner1);
        owners.add(owner2);

        when(ownerRepository.findAll()).thenReturn(owners);

        // When
        Set<Owner> actualOwners = service.findAll();

        assertNotNull(actualOwners);
        assertEquals(2, actualOwners.size());
    }

    @Test
    void save() {

        // Given
        String firstName = "Karl";
        Owner owner = new Owner();
        owner.setFirstName(firstName);
        when(ownerRepository.save(any())).thenReturn(owner);

        // When
        Owner actualOwner = service.save(owner);

        // Then
        assertNotNull(actualOwner);
        assertEquals(firstName, actualOwner.getFirstName());
        verify(ownerRepository).save(owner);
    }

    @Test
    void save_Null() {

        // Given
        Owner owner = new Owner();
        owner = null;

        // When
        Owner actualOwner = service.save(owner);

        // Then
        assertNull(actualOwner);
    }

    @Test
    void deleteById() {

        // Given
        Long id = 1L;

        // When
        service.deleteById(id);

        // Then
        verify(ownerRepository).deleteById(id);
    }

    @Test
    void delete() {

        // Given
        Owner owner = new Owner();

        // When
        service.delete(owner);

        // Then
        verify(ownerRepository).delete(owner);
    }

    @Test
    void findByLastName() {

        // Given
        String lastName = "Marx";

        Owner owner = new Owner();
        owner.setLastName(lastName);

        Set<Owner> givenOwners = new HashSet<>();
        givenOwners.add(owner);

        when(ownerRepository.findByLastName(lastName)).thenReturn(givenOwners);

        // When
        Set<Owner> owners = service.findByLastName(lastName);

        // Then
        assertEquals(1, owners.size());
    }

    @Test
    void findByLastName_NoMatch() {

        // Given
        String lastName = "Marx";

        Owner owner = new Owner();
        owner.setLastName("Bob");

        Set<Owner> givenOwners = new HashSet<>();

        when(ownerRepository.findByLastName(lastName)).thenReturn(givenOwners);

        // When
        Set<Owner> owners = service.findByLastName(lastName);

        // Then
        assertEquals(0, owners.size());
    }
}