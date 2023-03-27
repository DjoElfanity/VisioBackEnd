package com.example.userservice.Controller;

import com.example.userservice.Entity.User;
import com.example.userservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")

public class UserController {

   // @Autowired
    private UserService userService ;

    @GetMapping("/")
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id)
    {
        return userService.getUserById(id);
    }

    @PostMapping("/")
    public User creatUser (@RequestBody User user)
    {
        return userService.creatUser(user);
    }

    @PostMapping("/{id}")
    public User updateUser(@PathVariable String id , @RequestBody User user)
    {
        return userService.updaUser(id , user);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id)
    {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
