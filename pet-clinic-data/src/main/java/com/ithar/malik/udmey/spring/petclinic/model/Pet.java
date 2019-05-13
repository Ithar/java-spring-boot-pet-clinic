package com.ithar.malik.udmey.spring.petclinic.model;

import java.time.LocalDate;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Pet extends BaseEntity {

    private static final long serialVersionUID = -5891416855392196154L;

    private String name;
    private PetType petType;
    private Owner owner;
    private LocalDate birthDate;

}