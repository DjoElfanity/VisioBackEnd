package com.visioconference.notificationservice;

import com.visioconference.notificationservice.Entities.NotificationData;
import com.visioconference.notificationservice.Repository.NotificationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class NotificationServiceApplication {
    //@Autowired
    //private NotificationService notificationService;

    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }

    //@EventListener(ApplicationReadyEvent.class)
    //public void setNotificationService(){
    //    notificationService.sendNotification();
    //}

    @Bean
    public CommandLineRunner commandLineRunner(NotificationRepository notificationRepository, RepositoryRestConfiguration repositoryRestConfiguration)
    {
        return args -> {
            repositoryRestConfiguration.exposeIdsFor(NotificationData.class);
            notificationRepository.saveAll(
                    List.of(
                            NotificationData.builder()
                                    .id(1)
                                    .recipient("2")
                                    .subject("someone")
                                    .message("The first Notification")
                                    .sentDate(new Date())
                                    .build()
                    )
            );
            notificationRepository.findAll().forEach(System.out::println);
        };
    }

}
