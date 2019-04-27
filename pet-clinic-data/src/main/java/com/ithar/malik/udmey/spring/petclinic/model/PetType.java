package com.ithar.malik.udmey.spring.petclinic.model;

import java.util.Objects;

public class PetType extends BaseEntity {

    private static final long serialVersionUID = -5859880731552470953L;

    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PetType petType = (PetType) o;
        return Objects.equals(name, petType.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

