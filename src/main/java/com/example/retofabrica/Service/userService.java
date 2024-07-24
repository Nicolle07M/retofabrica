package com.example.retofabrica.Service;


import com.example.retofabrica.Entity.userEntity;
import com.example.retofabrica.Service.Dao.Idao;

import java.util.List;

public class userService implements Idao<userEntity, Long> {


    @Override
    public List<userEntity> findAll() {
        return List.of();
    }

    @Override
    public userEntity getById(Long aLong) {
        return null;
    }

    @Override
    public void update(userEntity entity) {

    }

    @Override
    public userEntity save(userEntity entity) {
        return null;
    }

    @Override
    public void delete(userEntity entity) {

    }

    @Override
    public void create(userEntity entity) {

    }
}
