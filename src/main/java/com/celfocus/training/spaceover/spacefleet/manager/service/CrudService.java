package com.celfocus.training.spaceover.spacefleet.manager.service;

import java.util.List;

public interface CrudService<T> {

    List<T> findAll();

    T findBydId(Long id);

    T save(T entity);

    T update(T entity);

    void deleteById(Long id);
}
