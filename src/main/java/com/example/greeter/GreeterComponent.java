package com.example.greeter;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("greeterComponent")
@Primary
public class GreeterComponent implements Greeter {
    @Override
    public String greet(String name) {
        return "Hello from @Component, " + name + "!";
    }
}
