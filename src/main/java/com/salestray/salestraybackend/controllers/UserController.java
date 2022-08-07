package com.salestray.salestraybackend.controllers;

import com.salestray.salestraybackend.entities.User;
import com.salestray.salestraybackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    @RequestMapping("/")
    public String home() {
        return "Hello Readers";
    }


    @RequestMapping(path = "/all")
    public @ResponseBody List<User> getAllUsers() {
        return this.userRepository.findAll();
    }
}
