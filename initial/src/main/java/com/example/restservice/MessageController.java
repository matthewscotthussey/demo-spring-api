package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private static final String template = "%s, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Message greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Message(counter.incrementAndGet(), String.format(template, "Hello", name));
    }

    @GetMapping("/goodbye")
    public Message goodbye(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Message(counter.incrementAndGet(), String.format(template, "Goodbye", name));
    }
}