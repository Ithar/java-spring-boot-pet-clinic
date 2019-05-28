package com.ithar.malik.udmey.spring.petclinic.model;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
@Entity
public class Address extends BaseEntity {

    private static final long serialVersionUID = -8652221602527671781L;

    private String address;
    private String city;
    private String telephone;

}
