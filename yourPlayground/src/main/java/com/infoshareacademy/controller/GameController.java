package com.infoshareacademy.controller;

import com.infoshareacademy.dto.GameDto;
import com.infoshareacademy.mappers.GameMapper;

import com.infoshareacademy.service.GameServiceTH;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.io.IOException;

@Controller
@RequestMapping("games")
public class GameController {


    private final GameServiceTH gameService;
    private final GameMapper gameMapper;

    public GameController(GameServiceTH gameService, GameMapper gameMapper) {
        this.gameService = gameService;
        this.gameMapper = gameMapper;
    }

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

    @PostMapping("new")
    public String postGame(@Valid @ModelAttribute("game") GameDto gameDto,
                           BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "game-form";
        }

        gameService.create(gameDto);
        return "game-form-success";
    }
}