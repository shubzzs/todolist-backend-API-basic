package com.todoapi.todoapi.Service;

import com.todoapi.todoapi.Entity.Task;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public interface TaskService {

    Task createTask(Task task);

    List<Task> getAllTasks();

    Optional<Task> getTask(Long id);

    Task updateTask(Long id , Task task);

    void deleteTask(Long id);
}
