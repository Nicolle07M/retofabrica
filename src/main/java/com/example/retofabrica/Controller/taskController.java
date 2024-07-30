package com.example.retofabrica.Controller;

import com.example.retofabrica.Entity.taskEntity;
import com.example.retofabrica.Business.taskBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class taskController {

    @Autowired
    private taskBusiness taskBusiness;

    @GetMapping
    public List<taskEntity> getAllTasks() {
        return taskBusiness.getAllTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<taskEntity> getTaskById(@PathVariable Long id) {
        Optional<taskEntity> task = taskBusiness.getTaskById(id);
        return task.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<taskEntity> createTask(@RequestBody taskEntity task) {
        try {
            taskEntity createdTask = taskBusiness.createTask(task);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<taskEntity> updateTask(@PathVariable Long id, @RequestBody taskEntity taskDetails) {
        Optional<taskEntity> updatedTask = taskBusiness.updateTask(id, taskDetails);
        return updatedTask.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        try {
            taskBusiness.deleteTask(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
