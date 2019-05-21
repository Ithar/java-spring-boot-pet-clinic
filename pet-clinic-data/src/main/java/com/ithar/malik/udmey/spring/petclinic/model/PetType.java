package com.ithar.malik.udmey.spring.petclinic.model;

import javax.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class PetType extends BaseEntity {

    private static final long serialVersionUID = -5859880731552470953L;

    private String typeName;

}

