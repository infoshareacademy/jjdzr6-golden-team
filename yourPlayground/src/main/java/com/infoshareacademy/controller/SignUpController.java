package com.infoshareacademy.controller;

import com.infoshareacademy.dto.PlayerDto;
import com.infoshareacademy.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;

@Controller
public class SignUpController {

    private final PlayerService playerService;

    public SignUpController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        PlayerDto userDto = new PlayerDto();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @PostMapping("/registration")
    public String savePlayer(@Valid @ModelAttribute("task") PlayerDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "task-form";
        }
        playerService.savePlayer(userDto);
        return "redirect:/dashboard";
    }
}
