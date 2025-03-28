package io.shs0160.greppapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecondController {

    @GetMapping("/page-1")
    public String showPage1() {
        // /templates/hello_page.html
        return "hello_page";
    }

    @GetMapping("/page-2")
    public String showPage2() {
        // /templates/hello_page.html
        return "txt_page";
    }

}
