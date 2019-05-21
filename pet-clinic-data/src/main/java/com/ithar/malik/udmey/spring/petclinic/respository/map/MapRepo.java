package com.ithar.malik.udmey.spring.petclinic.respository.map;

import com.ithar.malik.udmey.spring.petclinic.model.BaseEntity;
import com.ithar.malik.udmey.spring.petclinic.respository.BaseCurdRepository;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class MapRepo<T extends BaseEntity, ID extends Long> implements BaseCurdRepository<T, ID> {

     private Map<Long, T>  entities;

    public MapRepo() {
        this.entities = new HashMap<>();
    }

    @Override
    public T findById(ID id) {
        return entities.get(id);
    }

    @Override
    public Set<T> findAll() {
        return new HashSet<>(entities.values());
    }

    @Override
    public T save(T object) {

        if (object != null) {
            if (object.getId() == null) {
                object.setId(getNextId());
            }
            entities.put(object.getId(), object);
        } else {
            throw new RuntimeException("Saved object cannot be null");
        }

        return object;
    }

    @Override
    public void deleteById(ID id) {
        entities.remove(id);
    }

    @Override
    public void delete(T object) {
        entities.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId() {

        if (entities.isEmpty()) {
            return 1L;
        }

        return Collections.max(entities.keySet()) + 1;
    }
}
