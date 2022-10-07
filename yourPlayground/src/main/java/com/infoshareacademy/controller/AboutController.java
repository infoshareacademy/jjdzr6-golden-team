package com.infoshareacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {

    @GetMapping("/")
    public String getIndex() {
        return "about";
    }
}