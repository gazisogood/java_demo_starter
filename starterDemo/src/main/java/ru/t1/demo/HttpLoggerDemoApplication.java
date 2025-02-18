package ru.t1.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"ru.t1.java.demo.aspect", "ru.t1.demo.controllers"})
public class HttpLoggerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HttpLoggerDemoApplication.class, args);
    }
}
