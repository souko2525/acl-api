package com.example.springboottest.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public Map<String, String> hello() {
        return Collections.singletonMap("message", "Hello, World!");
    }
}
