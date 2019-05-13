package com.ithar.malik.udmey.spring.petclinic.service;

import com.ithar.malik.udmey.spring.petclinic.model.VetSpecialty;
import com.ithar.malik.udmey.spring.petclinic.respository.map.VetSpecialtyMapRepository;
import java.util.Set;

public class VetSpecialtyServiceImpl implements VetSpecialtyService {

    private final VetSpecialtyMapRepository repository;

    public VetSpecialtyServiceImpl(VetSpecialtyMapRepository repository) {
        this.repository = repository;
    }

    @Override
    public VetSpecialty findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Set<VetSpecialty> findAll() {
        return repository.findAll();
    }

    @Override
    public VetSpecialty save(VetSpecialty vetSpecialty) {
        return repository.save(vetSpecialty);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(VetSpecialty vetSpecialty) {
        repository.delete(vetSpecialty);
    }
}
