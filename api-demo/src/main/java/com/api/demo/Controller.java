package com.api.demo;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    private UserService userService;
    @GetMapping("/user")
    public List<User> getUserList() {
        return userService.findAll();
    }
    @GetMapping("/user/{userID}")
    public User getUser(@PathVariable(name = "userID") Long userID){
        return userService.findUser(userID);
    }
    @PutMapping("/user/{userID}")
    public User editUser(@PathVariable(name= "userID") Long userID,@RequestBody User user){
        return userService.updateUser(userID,user);
    }
}
