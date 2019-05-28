package com.ithar.malik.udmey.spring.petclinic.service;

import com.ithar.malik.udmey.spring.petclinic.model.Owner;
import com.ithar.malik.udmey.spring.petclinic.model.Pet;
import com.ithar.malik.udmey.spring.petclinic.respository.OwnerRepository;
import java.util.HashSet;
import java.util.Set;

public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository<Owner, Long> repository;
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceImpl(OwnerRepository<Owner, Long> repository, PetTypeService petTypeService, PetService petService) {
        this.repository = repository;
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find owner with id:"+id));
    }

    @Override
    public Set<Owner> findAll() {

        Set<Owner> owners = repository.findAll();

        if (!owners.isEmpty()) {
            return owners;
        }

        return new HashSet<>();
    }

    @Override
    public Owner save(Owner owner) {

        if (owner != null) {

            Set<Pet> pets = owner.getPets();

            if (pets != null && !pets.isEmpty()) {
                pets.forEach(pet -> {

                    if (pet == null)  {
                        return;
                    }

                    if (pet.getPetType() != null && pet.getPetType().getId() == null) {
                        petTypeService.save(pet.getPetType());
                    }

                    if (pet.getId() == null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }

            return repository.save(owner);
        }

        return null;
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(Owner owner) {
        repository.delete(owner);
    }

    @Override
    public Set<Owner> findByLastName(String lastName) {

        Set<Owner> owners = repository.findByLastName(lastName);

        if (!owners.isEmpty()) {
            return owners;
        }

        return new HashSet<>();
    }
}
