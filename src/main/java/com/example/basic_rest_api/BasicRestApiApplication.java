package com.example.basic_rest_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BasicRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicRestApiApplication.class, args);
    }
}