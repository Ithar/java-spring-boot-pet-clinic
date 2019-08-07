package com.ithar.malik.udmey.spring.petclinic.service;

import com.ithar.malik.udmey.spring.petclinic.dto.OwnerDTO;
import com.ithar.malik.udmey.spring.petclinic.mapper.OwnerMapperService;
import com.ithar.malik.udmey.spring.petclinic.model.Owner;
import com.ithar.malik.udmey.spring.petclinic.respository.OwnerRepository;
import java.util.HashSet;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
public class OwnerServiceImpl implements OwnerService {

    private final OwnerMapperService ownerMapperService;
    private final OwnerRepository<Owner, Long> repository;

    public OwnerServiceImpl(OwnerMapperService ownerMapperService,
        OwnerRepository<Owner, Long> repository) {
        this.ownerMapperService = ownerMapperService;
        this.repository = repository;
    }

    @Override
    public Owner findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find owner with id:" + id));
    }

    @Override
    @Transactional
    public Set<Owner> findAll() {

        Set<Owner> owners = new HashSet<>();

        repository.findAll().forEach(owners::add);

        if (!owners.isEmpty()) {
            return owners;
        }

        return new HashSet<>();
    }

    @Override
    public Owner save(Owner owner) {

        if (owner != null) {
            return repository.save(owner);
        }

        log.warn("Cannot have null owner ");
        return null;
    }

    @Override
    public Owner save(OwnerDTO ownerDTO) {
        Owner owner = ownerMapperService.mapToOwner(ownerDTO);
        return save(owner);
    }

    @Override
    public OwnerDTO mapToDTO(Owner owner) {
        return ownerMapperService.mapToOwnerDTO(owner);
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

        Set<Owner> owners = repository.findByLastName(lastName);

        if (!owners.isEmpty()) {
            return owners;
        }

        log.info("No owners found with last name equalling to {}", lastName);
        return new HashSet<>();
    }

    @Override
    public Set<Owner> findByLastNameLike(String lastName) {

        Set<Owner> owners = repository.findByLastNameContainingIgnoreCase(lastName);

        if (!owners.isEmpty()) {
            return owners;
        }

        log.info("No owners found with last name equalling to {}", lastName);
        return new HashSet<>();
    }

}
