package io.shs0160.greppapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/")
    public String hello() {
        System.out.println("Hello World");
        return "hello";
    }
}
