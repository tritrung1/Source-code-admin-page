package com.training.servcie;

import java.util.List;

public interface BaseService<T> {
    List<T> findAll();
    T findById(Long id);
    T save(T t);
    int update(T t);
    boolean delete(T t);
}
