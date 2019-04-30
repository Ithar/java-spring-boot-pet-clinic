package com.ithar.malik.udmey.spring.petclinic.respository;

import com.ithar.malik.udmey.spring.petclinic.model.Owner;
import java.util.HashMap;
import java.util.Map;

public class OwnerMapRepository extends MapRepository<Owner, Long> implements BaseCurdRepository<Owner, Long> {

    private Map<Owner, Long> entities = new HashMap<>();

    public OwnerMapRepository(Map<Long, Owner> entities) {
        super(entities);
    }

}
