package com.ithar.malik.udmey.spring.petclinic.service;

import com.ithar.malik.udmey.spring.petclinic.model.PetType;
import com.ithar.malik.udmey.spring.petclinic.respository.map.PetTypeMapRepository;
import java.util.Set;

public class PetTypeServiceImpl implements PetTypeService {

    private final PetTypeMapRepository repository;

    public PetTypeServiceImpl(PetTypeMapRepository repository) {
        this.repository = repository;
    }

    @Override
    public PetType findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Set<PetType> findAll() {
        return repository.findAll();
    }

    @Override
    public PetType save(PetType petType) {
        return repository.save(petType);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(PetType petType) {
        repository.delete(petType);
    }
}
