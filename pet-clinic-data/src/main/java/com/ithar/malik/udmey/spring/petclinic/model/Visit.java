package com.ithar.malik.udmey.spring.petclinic.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Visit extends BaseEntity  {

    private static final long serialVersionUID = -5169497214529444099L;

    private LocalDate date;
    private String description;
    private Pet pet;
}
