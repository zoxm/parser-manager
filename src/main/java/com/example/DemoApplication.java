package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        System.setProperty("spring.devtools.restart.enabled", "false");
        try {
        SpringApplication.run(DemoApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO: handle exception
        }
    }

}
