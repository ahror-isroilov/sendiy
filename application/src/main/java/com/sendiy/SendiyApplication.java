package com.sendiy;

import com.sendiy.user.UserDomain;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@SpringBootApplication
public class SendiyApplication {
    public static void main(String[] args) {
        SpringApplication.run(SendiyApplication.class, args);
    }
}
