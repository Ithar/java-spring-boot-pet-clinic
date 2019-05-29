package com.ithar.malik.udmey.spring.petclinic.respository.map;

import com.ithar.malik.udmey.spring.petclinic.model.Owner;
import com.ithar.malik.udmey.spring.petclinic.model.Pet;
import com.ithar.malik.udmey.spring.petclinic.model.PetType;
import com.ithar.malik.udmey.spring.petclinic.respository.OwnerRepository;
import com.ithar.malik.udmey.spring.petclinic.respository.PetRepository;
import com.ithar.malik.udmey.spring.petclinic.respository.PetTypeRepository;
import java.util.Set;
import java.util.stream.Collectors;

public class OwnerMapRepo extends MapRepo<Owner, Long> implements OwnerRepository<Owner, Long> {

    private final PetTypeRepository<PetType, Long> petTypeRepository;
    private final PetRepository<Pet, Long> petRepository;

    public OwnerMapRepo(
        PetTypeRepository<PetType, Long> petTypeRepository,
        PetRepository<Pet, Long> petRepository) {
        this.petTypeRepository = petTypeRepository;
        this.petRepository = petRepository;
    }

    @Override
    public Set<Owner> findByLastName(String lastName) {
        return
            findAll()
            .stream()
            .filter(owner -> lastName.equals(owner.getLastName()))
            .collect(Collectors.toSet());
    }

    @Override
    public Owner save(Owner owner) {

        Set<Pet> pets = owner.getPets();

        if (pets != null && !pets.isEmpty()) {
            pets.forEach(pet -> {

                if (pet == null)  {
                    return;
                }

                if (pet.getPetType() != null && pet.getPetType().getId() == null) {
                    petTypeRepository.save(pet.getPetType());
                }

                if (pet.getId() == null) {
                    Pet savedPet = petRepository.save(pet);
                    pet.setId(savedPet.getId());
                }
            });
        }

        return super.save(owner);
    }
}
