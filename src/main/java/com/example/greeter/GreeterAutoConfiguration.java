package com.example.greeter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreeterAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean(Greeter.class)
    public Greeter greeterAutoConfig() {
        return name -> "Hello from Auto-Configuration, " + name + "!";
    }
}
