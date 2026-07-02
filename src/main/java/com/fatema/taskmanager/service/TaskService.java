package com.fatema.taskmanager.service;

import com.fatema.taskmanager.model.Task;
import com.fatema.taskmanager.repository.TaskRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task updateTask(Long id, Task newTask) {
        Optional<Task> oldTask = taskRepository.findById(id);
        Task task = oldTask.get();

        task.setTitle(newTask.getTitle());
        task.setDesc(newTask.getDesc());
        task.setDone(newTask.isDone());
        return taskRepository.save(task);
    }
}
