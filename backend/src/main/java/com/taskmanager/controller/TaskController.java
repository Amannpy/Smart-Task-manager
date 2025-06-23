package com.taskmanager.controller;

import com.taskmanager.model.Task;
import com.taskmanager.repository.Repository;
import com.taskmanager.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@requestMapping("/api/tasks")
public class TaskController{
    @Autowired
    private TaskRepository taskRepository;

    // Get all tasks
    @GetMapping
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    // Get task by Id
    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable Long id){
        return taskRepository.findById(id);
    }

    // Create new task 
    @PostMapping
    public Task createTask(@RequestBody Task task){
        return taskRepository.save(task);
    }

    // Update a task
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask){
        updatedTask.setId(id);
        return taskRepository.save(updatedTask);
    }

    // Delete a Task
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskRepository.deleteById(id);
    }
}
