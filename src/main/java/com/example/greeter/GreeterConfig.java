package com.example.greeter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreeterConfig {
    @Bean
    public Greeter greeterFromConfig() {
        return name -> "Hello from Java Config, " + name + "!";
    }
}

