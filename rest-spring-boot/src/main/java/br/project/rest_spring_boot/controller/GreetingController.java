package br.project.rest_spring_boot.controller;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.project.rest_spring_boot.model.Greeting;

@RestController
public class GreetingController {

    private static final AtomicInteger COUNTER = new AtomicInteger();
    
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(defaultValue = "default") final String name) {
        return new Greeting(COUNTER.incrementAndGet(), String.format("Hello, %s!", name));
    }

}
