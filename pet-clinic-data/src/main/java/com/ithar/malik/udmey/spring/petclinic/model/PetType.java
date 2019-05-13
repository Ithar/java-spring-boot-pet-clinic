package com.ithar.malik.udmey.spring.petclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PetType extends BaseEntity {

    private static final long serialVersionUID = -5859880731552470953L;

    private String name;

}

