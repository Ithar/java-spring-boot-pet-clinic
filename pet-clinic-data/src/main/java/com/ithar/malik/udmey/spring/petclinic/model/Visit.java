package com.ithar.malik.udmey.spring.petclinic.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name="visits")
public class Visit extends BaseEntity {

    private static final long serialVersionUID = -5169497214529444099L;

    private LocalDate date;

    private String description;

    @ManyToOne
    //@JoinColumn(name = "pet_id")
    private Pet pet;

}
