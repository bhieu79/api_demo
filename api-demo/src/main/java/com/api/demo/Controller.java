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
    public List<User> search(@RequestParam(value = "search") String search) {
        return userService.search(search);
    }
    @GetMapping("/users/{userID}")
    public User getUser(@PathVariable(name = "userID") Long userID){
        return userService.findUser(userID);
    }
    @PutMapping("/users/{userID}")
    public User editUser(@PathVariable(name= "userID") Long userID,@RequestBody User user){
        return userService.updateUser(userID,user);
    }

}
