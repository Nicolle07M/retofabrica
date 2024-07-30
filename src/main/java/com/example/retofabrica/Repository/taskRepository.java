package com.example.retofabrica.Repository;


import com.example.retofabrica.Entity.taskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface taskRepository extends JpaRepository<taskEntity, Long> {

}
