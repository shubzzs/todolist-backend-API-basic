package com.todoapi.todoapi.controller;


import com.todoapi.todoapi.Entity.Task;
import com.todoapi.todoapi.Repository.TaskRepo;
import com.todoapi.todoapi.Service.Impl.TaskServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task-data")
public class TaskController {

    private final TaskServiceImpl taskServiceimpl;
    private final TaskRepo taskRepo;

    public TaskController(TaskServiceImpl taskServiceimpl, TaskRepo taskRepo) {
        this.taskServiceimpl = taskServiceimpl;
        this.taskRepo = taskRepo;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    @PostMapping("/addtask")
    public ResponseEntity<Task> addTask(@RequestBody Task task){
        Task newTask =taskServiceimpl.createTask(task);
        return ResponseEntity.ok(newTask);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id){
        Optional<Task> task = taskServiceimpl.getTask(id);
        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/tasks/update/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id , @RequestBody Task task){
        Task updateTask = taskServiceimpl.updateTask(id, task);
        return ResponseEntity.ok(updateTask);
    }


    @DeleteMapping("task/delete/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id){
        taskServiceimpl.deleteTask(id);
        return ResponseEntity.ok("Task deleted succesfully");
    }



}
