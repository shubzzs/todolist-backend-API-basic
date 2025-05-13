package com.todoapi.todoapi.Service.Impl;

import com.todoapi.todoapi.Entity.Task;
import com.todoapi.todoapi.Repository.TaskRepo;
import com.todoapi.todoapi.Service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepo taskRepo;

    public TaskServiceImpl(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    @Override
    public Task createTask(Task task) {
        return taskRepo.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    @Override
    public Optional<Task> getTask(Long id) {
        return taskRepo.findById(id);
    }

    @Override
    public Task updateTask(Long id, Task task) {
        Optional<Task> UpdatedTask = taskRepo.findById(id);
        if(UpdatedTask.isPresent()){
            Task task1 = UpdatedTask.get();
            task1.setTitle(task.getTitle());
            task1.setDescription(task.getDescription());
            task1.setCreated(task.getCreated());
            return taskRepo.save(task1);
        }else {
            throw new RuntimeException("Task not found");
        }
    }

    @Override
    public void deleteTask(Long id) {
        taskRepo.deleteById(id);
    }
}
