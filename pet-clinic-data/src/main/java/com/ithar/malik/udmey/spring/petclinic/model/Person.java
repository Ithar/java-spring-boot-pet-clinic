package com.ithar.malik.udmey.spring.petclinic.model;

import javax.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
class Person extends BaseEntity {

    private static final long serialVersionUID = 3976572168425929762L;

    private String firstName;

    private String lastName;

}