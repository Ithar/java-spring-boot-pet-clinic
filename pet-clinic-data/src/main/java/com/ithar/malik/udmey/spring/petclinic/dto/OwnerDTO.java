package com.ithar.malik.udmey.spring.petclinic.dto;

import com.ithar.malik.udmey.spring.petclinic.model.Pet;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;

@Data
public class OwnerDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String line1;
    private String city;
    private String telephone;
    private Set<Pet> pets = new HashSet<>();

}