package com.spring_security_jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring_security_jwt.model.User;
import com.spring_security_jwt.service.UserService;

@RestController

public class WelcomeController {
    @Autowired
    UserService userService;
    @GetMapping
    public String welcome(){
        return "MY REST API";
    }

    @GetMapping("/users")
    public String areaUser(){
        return "Area para USER/MAANGER";
    }

    @GetMapping("/managers")
    public String areaManager(){
        return "AREA PARA MANAGERS";
    }

    @GetMapping("/managers/viewUsers")
    public List<User> findusers(){
        return userService.findUsers();
    }

    @DeleteMapping("/remove")
    public String removeUser(@RequestBody User user){
        return userService.removeUser(user);
    }

    @PutMapping("/update")
    public String updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
}
