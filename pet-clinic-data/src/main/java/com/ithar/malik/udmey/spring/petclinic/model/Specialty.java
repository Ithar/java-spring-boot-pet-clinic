package com.ithar.malik.udmey.spring.petclinic.model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Specialty extends BaseEntity {

    private static final long serialVersionUID = -5559830093891781040L;

    private String description;

    @ManyToMany
    private Vet vet;
}
