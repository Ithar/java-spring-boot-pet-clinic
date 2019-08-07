package com.ithar.malik.udmey.spring.petclinic.mapper;

import com.ithar.malik.udmey.spring.petclinic.dto.OwnerDTO;
import com.ithar.malik.udmey.spring.petclinic.model.Owner;
import org.springframework.stereotype.Service;

@Service
public class OwnerMapperService {

    public Owner mapToOwner(OwnerDTO ownerDTO) {
        return OwnerMapper.INSTANCE.ownerFromDTO(ownerDTO);
    }

    public OwnerDTO mapToOwnerDTO(Owner owner) {
        return OwnerMapper.INSTANCE.ownerDTOFromOwner(owner);
    }

}
