package com.weatherweb.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Route {

    private UserRepository userRepository;

    public Route(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("")
    public List<User> getAllUsers(){
        return this.userRepository.findAll();
        //return "Hello World";
    }
    @PostMapping("")
    public User addUser(@RequestBody User user){
        return this.userRepository.save(user);
    }
    @DeleteMapping("")
    public void deleteUser(@RequestBody User user){
        this.userRepository.delete(user);
    }

}
