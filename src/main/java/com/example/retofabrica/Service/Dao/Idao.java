package com.example.retofabrica.Service.Dao;

import java.util.List;

public interface Idao<T, ID> {
    List<T> findAll();

    T getById(ID id);

    void update(T entity);

    T save(T entity);

    void delete(T entity);

    void create(T entity);
}
