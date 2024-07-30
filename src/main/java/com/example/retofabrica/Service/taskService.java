package com.example.retofabrica.Service;

import com.example.retofabrica.Entity.taskEntity;
import com.example.retofabrica.Repository.taskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class taskService {

    @Autowired
    private taskRepository taskRepository;

    public List<taskEntity> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<taskEntity> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public taskEntity createTask(taskEntity task) {
        return taskRepository.save(task);
    }

    public Optional<taskEntity> updateTask(Long id, taskEntity taskDetails) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setTitle(taskDetails.getTitle());
                    task.setDescription(taskDetails.getDescription());
                    task.setDueDate(taskDetails.getDueDate());
                    task.setStatus(taskDetails.getStatus());
                    task.setUser(taskDetails.getUser());
                    return taskRepository.save(task);
                });
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
