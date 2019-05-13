package com.ithar.malik.udmey.spring.petclinic.respository;

import com.ithar.malik.udmey.spring.petclinic.model.PetType;

public class PetTypeReposiotry extends MapRepository<PetType, Long> {

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public PetType save(PetType petType) {
        return super.save(petType);
    }

    @Override
    public void delete(PetType petType) {
        super.delete(petType);
    }
}
