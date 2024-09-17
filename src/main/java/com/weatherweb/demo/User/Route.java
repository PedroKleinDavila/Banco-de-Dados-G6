package com.weatherweb.demo.User;

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
    }
    @GetMapping("User/{id}")
    public User getUser(@PathVariable() long id){
        return this.userRepository.findById(id);
    }
    @PostMapping("")
    public User addUser(@RequestBody User user){
        return this.userRepository.save(user);
    }

    @DeleteMapping("")
    public void deleteUser(@RequestBody User user){
        this.userRepository.delete(user);
    }
    @PutMapping("")
    public User updateUser(@RequestBody User user){
        return this.userRepository.save(user);
    }
    @DeleteMapping("DeleteAll")
    public void deleteAllUsers() {
        this.userRepository.deleteAll();
    }
}
