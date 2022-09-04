package com.infoshareacademy.controller;

import com.infoshareacademy.entity.Player;
import com.infoshareacademy.repository.PlayerRepository;
import com.infoshareacademy.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PlayerController {

    private final PlayerService playerService;
    private final PlayerRepository playerRepository;

    @Secured("ROLE_ADMIN")
    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", playerService.getUsers());
        return "users";
    }

    @GetMapping("/player")

    public String players(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Player player = playerRepository.findByUsername(authentication.getName()).orElseThrow();

        model.addAttribute("player", playerService.findByUsername(player.getUsername()));
        return "player";
    }
}
