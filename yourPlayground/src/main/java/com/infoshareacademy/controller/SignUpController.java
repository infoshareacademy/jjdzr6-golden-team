package com.infoshareacademy.controller;

import com.infoshareacademy.dto.PlayerDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class SignUpController {

    @GetMapping("/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        PlayerDto userDto = new PlayerDto();
        model.addAttribute("user", userDto);
        return "registration";
    }
}
