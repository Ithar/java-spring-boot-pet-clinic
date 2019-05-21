package com.ithar.malik.udmey.spring.petclinic.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name="types")
public class PetType extends BaseEntity {

    private static final long serialVersionUID = -5859880731552470953L;

    private String typeName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "petType")
    private Pet pet;
}

