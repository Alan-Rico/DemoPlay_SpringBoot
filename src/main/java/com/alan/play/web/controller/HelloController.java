package com.alan.play.web.controller;

import com.alan.play.domain.service.DemoPlayAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final String plataform;
    private final DemoPlayAiService aiServices;

    public HelloController(@Value("${spring.application.name}") String plataform, DemoPlayAiService aiServices) {
        this.plataform = plataform;
        this.aiServices = aiServices;
    }


    @GetMapping("/hello")
    public String hello() {
        return this.aiServices.generateGreeting(plataform);
    }
}
