package com.api.demo;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.api.demo.User;
import com.api.demo.UserRepository;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User add(User user){
        return userRepository.save(user);
    }
    public User findUser(Long userID){
        return userRepository.findUserByDefQuery(userID);
    }
    public User updateUser(Long userID,User user){
        user.setId(userID);
        return userRepository.save(user);
    }
}
