package com.api.demo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class Controller {
    @Autowired
    private UserService userService;
    @GetMapping("/users")
    public List<User> getAllUser(){
        return userService.findAll();
    }
    @GetMapping("/users/{userID}")
    public User getUser(@PathVariable(name = "userID") Long userID){
        return userService.findUser(userID);
    }
    @PutMapping("/users/{userID}")
    public User editUser(@PathVariable(name= "userID") Long userID,@RequestBody User user){
        return userService.updateUser(userID,user);
    }
    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        return userService.add(user);
    }
    @DeleteMapping("/users/{userID}")
    public void deleteUser(@PathVariable(name ="userID") Long userID){
        userService.deleteUser(userID);
    }
}
