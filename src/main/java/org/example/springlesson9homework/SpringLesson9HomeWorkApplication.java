package org.example.springlesson9homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringLesson9HomeWorkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringLesson9HomeWorkApplication.class, args);
    }

}
