package com.infoshareacademy.controller;

import com.infoshareacademy.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PlayersController {

    private final PlayerService playerService;

    @Secured("ROLE_ADMIN")
    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", playerService.getUsers());
        return "users";
    }
}
