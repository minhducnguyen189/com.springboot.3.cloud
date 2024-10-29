package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class OpenFeignResilience4jApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignResilience4jApplication.class, args);
    }
}