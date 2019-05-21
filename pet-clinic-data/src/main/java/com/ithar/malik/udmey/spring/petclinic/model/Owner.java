package com.ithar.malik.udmey.spring.petclinic.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Owner extends Person {

    private static final long serialVersionUID = -4864946874173774947L;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

}
