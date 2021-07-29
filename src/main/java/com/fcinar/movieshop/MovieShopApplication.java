package com.fcinar.movieshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class MovieShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieShopApplication.class, args);
    }
}