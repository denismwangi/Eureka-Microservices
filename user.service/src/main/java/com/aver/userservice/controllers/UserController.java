package com.aver.userservice.controllers;


import com.aver.userservice.VO.ResponseTemplateVO;
import com.aver.userservice.entity.User;
import com.aver.userservice.repository.UserRepository;
import com.aver.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {


    private final UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    UserService userService;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/")
    public List<User> all()
    {
      return  userRepository.findAll();
    }

    @PostMapping("/create")
    public User newUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserDepartment(@PathVariable("id") Long id){
        return userService.getUserWithDepartmnet(id);
    }
}
