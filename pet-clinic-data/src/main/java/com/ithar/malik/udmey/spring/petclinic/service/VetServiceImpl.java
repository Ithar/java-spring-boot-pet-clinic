package com.ithar.malik.udmey.spring.petclinic.service;

import com.ithar.malik.udmey.spring.petclinic.model.Specialty;
import com.ithar.malik.udmey.spring.petclinic.model.Vet;
import com.ithar.malik.udmey.spring.petclinic.respository.map.VetMapRepo;
import com.ithar.malik.udmey.spring.petclinic.respository.map.VetSpecialtyMapRepo;
import java.util.Set;

public class VetServiceImpl implements VetService {

    private final VetMapRepo vetMapRepository;
    private final VetSpecialtyMapRepo vetSpecialtyMapRepository;

    public VetServiceImpl(VetMapRepo vetMapRepository, VetSpecialtyMapRepo vetSpecialtyMapRepository) {
        this.vetMapRepository = vetMapRepository;
        this.vetSpecialtyMapRepository = vetSpecialtyMapRepository;
    }

    @Override
    public Vet findById(Long id) {
        return vetMapRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find vet with id: "+id));
    }

    @Override
    public Set<Vet> findAll() {
        return vetMapRepository.findAll();
    }

    @Override
    public Vet save(Vet vet) {

        if (vet != null) {

            Set<Specialty> specialties = vet.getSpecialties();
            if (specialties != null && !specialties.isEmpty()) {

                specialties.forEach(specialty -> {
                    if (specialty != null && specialty.getId() == null) {
                        Specialty savedSpecialty = vetSpecialtyMapRepository.save(specialty);
                        specialty.setId(savedSpecialty.getId());
                    }
                });
            }

            return vetMapRepository.save(vet);
        }

        return null; // TODO [IM 19-05-13] - Change this to optional
    }

    @Override
    public void deleteById(Long id) {
        vetMapRepository.deleteById(id);
    }

    @Override
    public void delete(Vet vet) {
        vetMapRepository.delete(vet);
    }
}
