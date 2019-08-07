package com.ithar.malik.udmey.spring.petclinic.mapper;

import com.ithar.malik.udmey.spring.petclinic.dto.OwnerDTO;
import com.ithar.malik.udmey.spring.petclinic.model.Owner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OwnerMapper {

    OwnerMapper INSTANCE = Mappers.getMapper(OwnerMapper.class);

    @Mapping(source = "line1", target = "address.line1")
    @Mapping(source = "city", target = "address.city")
    @Mapping(source = "telephone", target = "address.telephone")
    Owner ownerFromDTO(OwnerDTO ownerDTO);

    @Mapping(source = "address.line1", target = "line1")
    @Mapping(source = "address.city", target = "city")
    @Mapping(source = "address.telephone", target = "telephone")
    OwnerDTO ownerDTOFromOwner(Owner owner);
}
