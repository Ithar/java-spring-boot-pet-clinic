package com.ithar.malik.udmey.spring.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name="types")
public class PetType extends BaseEntity {

    private static final long serialVersionUID = -5859880731552470953L;

    @Column(name = "type_name")
    private String name;

}

