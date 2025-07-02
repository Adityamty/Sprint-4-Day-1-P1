package com.example.greeter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringBootGreeterApplication {

    @Autowired
    private Greeter greeter;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootGreeterApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void greetOnStartup() {
        System.out.println(greeter.greet("World"));
    }
}
