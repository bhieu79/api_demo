package com.api.demo;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
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
    public List<User> search(String search){
        UserSpecificationsBuilder builder = new UserSpecificationsBuilder();
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
        Matcher matcher = pattern.matcher(search + ",");
        while (matcher.find()) {
            builder.with(matcher.group(1), SearchOperation.getSimpleOperation(matcher.group(2).charAt(0)), matcher.group(3));
        }

        Specification<User> spec = builder.build();
        return userRepository.findAll(spec);
    }
}
