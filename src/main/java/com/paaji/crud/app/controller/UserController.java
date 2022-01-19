package com.paaji.crud.app.controller;

import com.paaji.crud.app.entity.User;
import com.paaji.crud.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService theUserService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return theUserService.getAllUsers();
    }

    @PostMapping("/users")
    public User addNewUser(@RequestBody User theUserToBeAdded) {
        return theUserService.addNewUser(theUserToBeAdded);
    }

    @PutMapping("/users/{userId}")
    public User updateExistingUserById(@PathVariable Integer userId, @RequestBody User userToBeUpdated) {
        return theUserService.updateExistingUserById(userId, userToBeUpdated);
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUserById(@PathVariable Integer userId) {
        theUserService.deleteUserById(userId);
        return "User Deleted Successfully!!";
    }
}
