package com.example.retofabrica.Repository;

import com.example.retofabrica.Entity.rolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface rolRepository extends JpaRepository<rolEntity, Long> {
    Optional<rolEntity> findByRolType(String rolType);
}
