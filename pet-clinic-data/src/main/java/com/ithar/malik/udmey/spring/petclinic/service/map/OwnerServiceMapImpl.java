package com.ithar.malik.udmey.spring.petclinic.service.map;

import com.ithar.malik.udmey.spring.petclinic.model.Owner;
import com.ithar.malik.udmey.spring.petclinic.respository.OwnerMapRepository;
import com.ithar.malik.udmey.spring.petclinic.service.OwnerService;
import java.util.Set;

public class OwnerServiceMapImpl implements OwnerService {

    private final OwnerMapRepository repository;

    public OwnerServiceMapImpl(OwnerMapRepository repository) {
        this.repository = repository;
    }

    @Override
    public Owner findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Set<Owner> findAll() {
        return repository.findAll();
    }

    @Override
    public Owner save(Owner owner) {
        return repository.save(owner.getId(), owner);
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
        return null; // TODO - [IM 19-05-01] - Needs implementation
    }
}
