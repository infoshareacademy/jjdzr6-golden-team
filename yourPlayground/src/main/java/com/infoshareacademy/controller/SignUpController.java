package com.infoshareacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignUpController {

    @GetMapping("/registration")
    public String signIn() {
        return "sign-in";
    }
}
