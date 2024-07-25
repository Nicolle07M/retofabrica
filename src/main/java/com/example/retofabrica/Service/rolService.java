package com.example.retofabrica.Service;

import com.example.retofabrica.Entity.rolEntity;
import com.example.retofabrica.Service.Dao.Idao;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.retofabrica.Repository.rolRepository;

import java.util.List;

public class rolService implements Idao<rolEntity, Long> {
    @Autowired
    rolRepository rolRepository;

    @Override
    public List<rolEntity> findAll() {
        return List.of();
    }

    @Override
    public rolEntity getById(Long aLong) {
        return null;
    }

    @Override
    public void update(rolEntity entity) {
        this.rolRepository.save(entity);

    }

    @Override
    public rolEntity save(rolEntity entity) {
        return this.rolRepository.save(entity);
    }

    @Override
    public void delete(rolEntity entity) {
        this.rolRepository.delete(entity);

    }

    @Override
    public void create(rolEntity entity) {
        this.rolRepository.save(entity);

    }
}