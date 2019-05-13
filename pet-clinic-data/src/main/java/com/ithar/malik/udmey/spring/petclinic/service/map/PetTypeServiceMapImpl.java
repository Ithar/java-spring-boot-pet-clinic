package com.ithar.malik.udmey.spring.petclinic.service.map;

import com.ithar.malik.udmey.spring.petclinic.model.PetType;
import com.ithar.malik.udmey.spring.petclinic.respository.PetTypeReposiotry;
import com.ithar.malik.udmey.spring.petclinic.service.PetTypeService;
import java.util.Set;

public class PetTypeServiceMapImpl implements PetTypeService {

    private final PetTypeReposiotry reposiotry;

    public PetTypeServiceMapImpl(PetTypeReposiotry reposiotry) {
        this.reposiotry = reposiotry;
    }

    @Override
    public PetType findById(Long id) {
        return reposiotry.findById(id);
    }

    @Override
    public Set<PetType> findAll() {
        return reposiotry.findAll();
    }

    @Override
    public PetType save(PetType petType) {
        return reposiotry.save(petType);
    }

    @Override
    public void deleteById(Long id) {
        reposiotry.deleteById(id);
    }

    @Override
    public void delete(PetType petType) {
        reposiotry.delete(petType);
    }
}
