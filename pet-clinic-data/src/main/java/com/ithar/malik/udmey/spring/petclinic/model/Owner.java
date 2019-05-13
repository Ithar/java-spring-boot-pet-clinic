package com.ithar.malik.udmey.spring.petclinic.model;

import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Owner extends Person {

    private Set<Pet> pets = new HashSet<>();
    private Address address;

}
