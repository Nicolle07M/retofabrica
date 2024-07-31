package com.example.retofabrica.Repository;// RolRepository.java
import com.example.retofabrica.Entity.rolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface rolRepository extends JpaRepository<rolEntity, Long> {
}
