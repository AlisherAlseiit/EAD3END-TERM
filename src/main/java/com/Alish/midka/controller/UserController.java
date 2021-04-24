package com.Alish.midka.controller;


import com.Alish.midka.Service.UserService;
import com.Alish.midka.model.User;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")

public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/id")
    public Optional<User> getUserById(@PathVariable("id") Long id){
        return userService.getUser(id);
    }

    @PostMapping("/signUp")
    public void signUp(@RequestBody User user){

        userService.createUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id,
                           @RequestBody User user) {

        userService.updateUser(id, user);
    }

    @PatchMapping("/{id}")
    public void updateUserName(@PathVariable Long id,
                               @RequestParam String username){

        userService.updateUserName(id, username);
    }




}

















