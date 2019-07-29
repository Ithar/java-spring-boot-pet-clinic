package com.ithar.malik.udmey.spring.petclinic.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(callSuper = true, exclude = {"pets"})
@Getter
@Setter
@Entity
@Table(name="types")
public class PetType extends BaseEntity {

    private static final long serialVersionUID = -5859880731552470953L;

    private String typeName;

    @OneToMany(mappedBy = "petType")
    private Set<Pet> pets = new HashSet<>();
}

