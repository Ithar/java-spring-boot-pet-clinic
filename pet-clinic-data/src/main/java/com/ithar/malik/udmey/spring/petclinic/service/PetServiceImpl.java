package com.ithar.malik.udmey.spring.petclinic.service;

import com.ithar.malik.udmey.spring.petclinic.model.Pet;
import com.ithar.malik.udmey.spring.petclinic.respository.map.PetMapRepo;
import java.util.Set;

public class PetServiceImpl implements PetService {

    private final PetMapRepo repository;

    public PetServiceImpl(PetMapRepo repository) {
        this.repository = repository;
    }

    @Override
    public Pet findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find pet with id: "+id));
    }

    @Override
    public Set<Pet> findAll() {
        return repository.findAll();
    }

    @Override
    public Pet save(Pet pet) {
        return repository.save(pet);
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