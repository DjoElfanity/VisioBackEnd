package com.example.messageservice;

import com.example.messageservice.Entity.Message;
import com.example.messageservice.Repository.MessageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class MessageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageServiceApplication.class, args);

    }

    @Bean
    public CommandLineRunner commandLineRunner(MessageRepository messageRepository, RepositoryRestConfiguration repositoryRestConfiguration)
    {
        return args -> {
            repositoryRestConfiguration.exposeIdsFor(Message.class);
            messageRepository.saveAll(
                    List.of(
                            Message.builder().senderId(1)
                                    .recipentId(2)
                                    .content("Hello world!")
                                    .sendDateTime(new Date())
                                    .isPrivate(false)
                                    .build()

                    )
            );
            messageRepository.findAll().forEach(c->{
                System.out.println(c);
            });
        };
    }
}
