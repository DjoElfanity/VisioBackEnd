package com.example.userservice;

import com.example.userservice.Entity.User;
import com.example.userservice.Repository.UserRepository;
import com.example.userservice.Service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication


public class UserServiceApplication {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {

        SpringApplication.run(UserServiceApplication.class, args);



    }


    @Bean
    public CommandLineRunner commandLineRunner(UserRepository userRepository, RepositoryRestConfiguration repositoryRestConfiguration)
    {
        return args -> {
            repositoryRestConfiguration.exposeIdsFor(User.class);
            userRepository.saveAll(
                    List.of(
                            User.builder().nom("Jad").email("jadfanity@yahoo.fr").build()

                    )
            );
            userRepository.findAll().forEach(c->{
                System.out.println(c);
            });
        };
    }




}
