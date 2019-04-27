package com.ithar.malik.udmey.spring.petclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Person extends BaseEntity {

    private static final long serialVersionUID = 3976572168425929762L;
    private String firstName;
    private String lastName;

}