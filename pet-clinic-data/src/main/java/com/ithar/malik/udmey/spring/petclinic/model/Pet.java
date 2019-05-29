package com.ithar.malik.udmey.spring.petclinic.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name="pets")
public class Pet extends BaseEntity {

    private static final long serialVersionUID = -5891416855392196154L;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name="owner_id")
    private Owner owner;

    @OneToOne(fetch = FetchType.LAZY)
    private PetType petType;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();

    private LocalDate birthDate;

}