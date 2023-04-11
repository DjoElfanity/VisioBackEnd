package com.example.userservice.Service;

import com.example.userservice.Entity.User;
import com.example.userservice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository ;

    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());
    }

    public User creatUser(User user)
    {
        return userRepository.save(user);
    }

    public User updateUser(int id , User user)
    {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setDateNaissance(user.getDateNaissance());
        existingUser.setNom(user.getNom());
        existingUser.setPrenom(user.getPrenom());
        return userRepository.save(existingUser);
    }

    public void deleteUser(int id)
    {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
        userRepository.delete(user);
    }

}
