package com.ithar.malik.udmey.spring.petclinic.respository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class MapRepository<T, ID> implements BaseCurdRepository<T, ID> {

     private Map<ID, T>  entities;

    public MapRepository() {
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
    public T save(ID id, T object) {
        entities.put(id, object);
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
}
