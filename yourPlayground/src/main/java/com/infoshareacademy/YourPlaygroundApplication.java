package com.infoshareacademy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.infoshareacademy.repository")
public class YourPlaygroundApplication {
    public static void main(String[] args) {
        SpringApplication.run(YourPlaygroundApplication.class, args);
    }
}
