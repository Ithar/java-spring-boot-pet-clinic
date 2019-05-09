package com.ithar.malik.udmey.spring.petclinic.model;

import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Vet extends Person {

    private Set<VetSpecialty> specialties;

}
