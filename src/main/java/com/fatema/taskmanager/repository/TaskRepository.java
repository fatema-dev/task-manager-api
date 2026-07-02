package com.fatema.taskmanager.repository;

import com.fatema.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//for CRUD Operations
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
