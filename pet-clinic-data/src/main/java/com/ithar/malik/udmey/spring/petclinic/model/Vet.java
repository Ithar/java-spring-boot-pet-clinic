package com.ithar.malik.udmey.spring.petclinic.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Vet extends Person {

    private static final long serialVersionUID = 2415604854164492983L;

    @ManyToMany
    @JoinTable(
        name="vet_specialty",
        joinColumns = @JoinColumn(name="specialties_id"),
        inverseJoinColumns = @JoinColumn(name = "vet_id"))
    private Set<VetSpecialty> specialties = new HashSet<>();

}
