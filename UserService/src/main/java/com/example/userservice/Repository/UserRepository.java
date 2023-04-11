package com.example.userservice.Repository;

import com.example.userservice.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository  extends JpaRepository<User , Integer> {


    User findByUsername(String username);

    User findByEmail(String email);

    User save(User user);

}
