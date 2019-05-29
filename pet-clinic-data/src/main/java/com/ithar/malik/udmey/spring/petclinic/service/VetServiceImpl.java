package com.ithar.malik.udmey.spring.petclinic.service;

import com.ithar.malik.udmey.spring.petclinic.model.Specialty;
import com.ithar.malik.udmey.spring.petclinic.model.Vet;
import com.ithar.malik.udmey.spring.petclinic.respository.SpecialtyRepository;
import com.ithar.malik.udmey.spring.petclinic.respository.VetRepository;
import java.util.HashSet;
import java.util.Set;

public class VetServiceImpl implements VetService {

    private final VetRepository<Vet, Long> vetRepository;
    private final SpecialtyRepository<Specialty, Long> specialtyRepository;

    public VetServiceImpl(VetRepository<Vet, Long> vetRepository,
        SpecialtyRepository<Specialty, Long> specialtyRepository) {
        this.vetRepository = vetRepository;
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Vet findById(Long id) {
        return vetRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find vet with id: "+id));
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet save(Vet vet) {

        if (vet != null) {

            Set<Specialty> specialties = vet.getSpecialties();
            if (specialties != null && !specialties.isEmpty()) {

                specialties.forEach(specialty -> {
                    if (specialty != null && specialty.getId() == null) {
                        Specialty savedSpecialty = specialtyRepository.save(specialty);
                        specialty.setId(savedSpecialty.getId());
                    }
                });
            }

            return vetRepository.save(vet);
        }

        return null; // TODO [IM 19-05-13] - Change this to optional
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }

    @Override
    public void delete(Vet vet) {
        vetRepository.delete(vet);
    }
}
