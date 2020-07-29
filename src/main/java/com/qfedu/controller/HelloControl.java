package com.qfedu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControl {

    @GetMapping("/aaa")
    public String index(){
        return "aaa";
    }
}
