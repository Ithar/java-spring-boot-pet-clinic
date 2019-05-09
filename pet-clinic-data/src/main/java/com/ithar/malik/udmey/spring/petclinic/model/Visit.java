package com.ithar.malik.udmey.spring.petclinic.model;

import java.time.LocalDate;
import lombok.Data;

@Data
public class Visit extends BaseEntity  {

    private LocalDate date;
    private String description;
    private Pet pet;
}
