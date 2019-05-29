package com.ithar.malik.udmey.spring.petclinic.service;

import com.ithar.malik.udmey.spring.petclinic.model.Specialty;
import com.ithar.malik.udmey.spring.petclinic.respository.SpecialtyRepository;
import java.util.HashSet;
import java.util.Set;

public class VetSpecialtyServiceImpl implements VetSpecialtyService {

    private final SpecialtyRepository<Specialty, Long> repository;

    public VetSpecialtyServiceImpl(
        SpecialtyRepository<Specialty, Long> repository) {
        this.repository = repository;
    }

    @Override
    public Specialty findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find specialty with id: "+id));
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        repository.findAll().forEach(specialties::add);
        return specialties;
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
