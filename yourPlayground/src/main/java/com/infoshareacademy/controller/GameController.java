package com.infoshareacademy.controller;

import com.infoshareacademy.dto.GameDto;
import com.infoshareacademy.entity.Player;
import com.infoshareacademy.mappers.GameMapper;

import com.infoshareacademy.repository.PlayerRepository;
import com.infoshareacademy.service.GameServiceTH;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.io.IOException;

@Controller
@RequestMapping("games")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GameController {


    private final GameServiceTH gameService;

    private final PlayerRepository playerRepository;

    @GetMapping("{id}")
    public String getGame(@PathVariable Integer id, Model model) throws IOException {
        model.addAttribute("game", gameService.findById(id));
        return "game";
    }

    @GetMapping
    public String getGames(Model model) {
        model.addAttribute("games", gameService.findAll());
        return "games";
    }

    @GetMapping("new")
    public String createGame(Model model) throws IOException {
        model.addAttribute("game", new GameDto());
        return "game-form";
    }

    @Secured("ROLE_USER")
    @PostMapping("new")
    public String postGame(@Valid @ModelAttribute("game") GameDto gameDto,
                           BindingResult bindingResult) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getName());
        System.out.println(playerRepository.findByUsername(authentication.getName()).toString());

        Player gameOwner = playerRepository.findByUsername(authentication.getName()).get();

        System.out.println(gameOwner.toString());

        if(bindingResult.hasErrors()) {
            return "game-form";
        }

        gameService.create(gameDto, gameOwner);
        return "game-form-success";
    }
}