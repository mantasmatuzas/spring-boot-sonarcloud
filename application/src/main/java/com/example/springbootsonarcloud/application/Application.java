package com.example.springbootsonarcloud.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = "com.example")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
