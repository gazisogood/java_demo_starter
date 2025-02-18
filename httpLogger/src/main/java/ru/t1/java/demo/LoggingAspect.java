package ru.t1.java.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggingAspect {

    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }
}
