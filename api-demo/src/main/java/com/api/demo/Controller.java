package com.api.demo;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    private UserService userService;
    @GetMapping("/user")
    public List<User> search(@RequestParam(value = "search") String search) {
        return userService.search(search);
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
