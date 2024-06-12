package com.example.flutterconnenttest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TestController {

    @GetMapping("/test")
    public String test1(){
        return "test";
    }
}