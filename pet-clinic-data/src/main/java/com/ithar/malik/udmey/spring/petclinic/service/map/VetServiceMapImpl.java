package com.ithar.malik.udmey.spring.petclinic.service.map;

import com.ithar.malik.udmey.spring.petclinic.model.Vet;
import com.ithar.malik.udmey.spring.petclinic.respository.VetMapRepository;
import com.ithar.malik.udmey.spring.petclinic.service.VetService;
import java.util.Set;

public class VetServiceMapImpl implements VetService {

    private final VetMapRepository repository;

    public VetServiceMapImpl(VetMapRepository repository) {
        this.repository = repository;
    }

    @Override
    public Vet findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Set<Vet> findAll() {
        return repository.findAll();
    }

    @Override
    public Vet save(Vet vet) {
        return repository.save(vet.getId(), vet);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(Vet vet) {
        repository.delete(vet);
    }
}
