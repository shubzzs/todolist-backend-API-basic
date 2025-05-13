package com.todoapi.todoapi.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class HelloGreets {

    @GetMapping
    public String greet(){
        return "hello world !";
    }

}
