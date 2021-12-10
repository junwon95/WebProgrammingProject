package com.example.webpproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan({"com.example.webpproject.model"})
@SpringBootApplication
public class WebpprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebpprojectApplication.class, args);
    }

}
