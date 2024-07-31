package com.example.retofabrica.Service;

import com.example.retofabrica.Entity.taskEntity;
import com.example.retofabrica.Service.taskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class taskService {

    @Autowired
    private taskService taskService;

    public List<taskEntity> getAllTasks() {
        return taskService.getAllTasks();
    }

    public Optional<taskEntity> getTaskById(Long id) {
        return taskService.getTaskById(id);
    }

    public taskEntity createTask(taskEntity task) {
        return taskService.createTask(task);
    }

    public Optional<taskEntity> updateTask(Long id, taskEntity taskDetails) {
        return taskService.updateTask(id, taskDetails);
    }

    public void deleteTask(Long id) {
        taskService.deleteTask(id);
    }
}