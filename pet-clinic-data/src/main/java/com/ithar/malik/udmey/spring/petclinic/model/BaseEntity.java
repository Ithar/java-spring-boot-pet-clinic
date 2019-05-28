package com.ithar.malik.udmey.spring.petclinic.model;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(of = "id")
@MappedSuperclass
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -938023197761186312L;

    @Id
    Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
