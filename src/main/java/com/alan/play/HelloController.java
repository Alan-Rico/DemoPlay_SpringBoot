package com.alan.play;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final DemoPlayAiService aiServices;

    public HelloController(DemoPlayAiService aiServices) {
        this.aiServices = aiServices;
    }


    @GetMapping("/")
    public String hello() {
        return this.aiServices.generateGreeting();
    }
}
