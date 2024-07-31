package com.example.retofabrica.Repository;// UserRepository.java
import com.example.retofabrica.Entity.userEntity;
import com.example.retofabrica.Entity.rolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface userRepository extends JpaRepository<userEntity, Long> {
    List<userEntity> findByRol(rolEntity rol);
}
