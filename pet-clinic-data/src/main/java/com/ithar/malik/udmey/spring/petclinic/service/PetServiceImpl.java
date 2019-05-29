package com.ithar.malik.udmey.spring.petclinic.service;

import com.ithar.malik.udmey.spring.petclinic.model.Pet;
import com.ithar.malik.udmey.spring.petclinic.respository.PetRepository;
import java.util.HashSet;
import java.util.Set;

public class PetServiceImpl implements PetService {

    private final PetRepository<Pet, Long> repository;

    public PetServiceImpl(PetRepository repository) {
        this.repository = repository;
    }

    @Override
    public Pet findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find pet with id: "+id));
    }

    @Override
    public Set<Pet> findAll() {
        Set pets = new HashSet();
        repository.findAll().forEach(pets::add);
        return pets;
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
