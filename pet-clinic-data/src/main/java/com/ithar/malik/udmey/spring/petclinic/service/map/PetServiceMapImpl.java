package com.ithar.malik.udmey.spring.petclinic.service.map;

import com.ithar.malik.udmey.spring.petclinic.model.Pet;
import com.ithar.malik.udmey.spring.petclinic.respository.PetMapRepository;
import com.ithar.malik.udmey.spring.petclinic.service.PetService;
import java.util.Set;

public class PetServiceMapImpl implements PetService {

    private final PetMapRepository repository;

    public PetServiceMapImpl(PetMapRepository repository) {
        this.repository = repository;
    }

    @Override
    public Pet findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Set<Pet> findAll() {
        return repository.findAll();
    }

    @Override
    public Pet save(Pet pet) {
        return repository.save(pet.getId(), pet);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(Pet pet) {
        repository.delete(pet);
    }
}
