package com.ithar.malik.udmey.spring.petclinic.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Pet extends BaseEntity {

    private static final long serialVersionUID = -5891416855392196154L;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Owner owner;

    @OneToOne
    private PetType petType;

    private LocalDate birthDate;

}