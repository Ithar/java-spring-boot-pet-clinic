package com.ithar.malik.udmey.spring.petclinic.model;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Entity
public class Address {

    private String address;
    private String city;
    private String telephone;

}
