package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Helloworldcontroller {
    @RequestMapping("/")
    public String hello()
    {
        return "Hello World";
    }
}
