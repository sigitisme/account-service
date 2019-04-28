package com.github.sigitisme.accountservice.data.services;

import java.util.List;
import java.util.Optional;

public interface CrudService<T> {
    List<T> findAll();
    Optional<T> findById(Long id);
    T save(T t);
}
