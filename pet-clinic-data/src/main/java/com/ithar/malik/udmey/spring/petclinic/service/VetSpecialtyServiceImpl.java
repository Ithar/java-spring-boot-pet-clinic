package com.ithar.malik.udmey.spring.petclinic.service;

import com.ithar.malik.udmey.spring.petclinic.model.Specialty;
import com.ithar.malik.udmey.spring.petclinic.respository.map.VetSpecialtyMapRepo;
import java.util.Set;

public class VetSpecialtyServiceImpl implements VetSpecialtyService {

    private final VetSpecialtyMapRepo repository;

    public VetSpecialtyServiceImpl(VetSpecialtyMapRepo repository) {
        this.repository = repository;
    }

    @Override
    public Specialty findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Set<Specialty> findAll() {
        return repository.findAll();
    }

    @Override
    public Specialty save(Specialty specialty) {
        return repository.save(specialty);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(Specialty specialty) {
        repository.delete(specialty);
    }
}
