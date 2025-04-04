package com.example.mySpring.services;

import java.util.List;

public interface IService<T, ID> {
    List<T> findAll();
    T findById(ID id);
    T save(T entity);
    void delete(ID id);
}
