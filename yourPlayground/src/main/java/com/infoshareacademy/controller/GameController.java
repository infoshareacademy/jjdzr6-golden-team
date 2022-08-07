package com.infoshareacademy.controller;

import com.infoshareacademy.dto.GameDto;
import com.infoshareacademy.mappers.GameMapper;
import com.infoshareacademy.model.Game;
import com.infoshareacademy.service.GameServiceImpl;
import com.infoshareacademy.utils.GameType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class GameController {


    private final GameServiceImpl gameService;
    private final GameMapper gameMapper;

    public GameController(GameServiceImpl gameService, GameMapper gameMapper) {
        this.gameService = gameService;
        this.gameMapper = gameMapper;
    }

    @GetMapping("/games/{id}")
    public String getGame(@PathVariable Long id, Model model) throws IOException {
        Game game = new Game("Football", 12, GameType.SPORTS);
        model.addAttribute("game", gameMapper.toDto(game));
        return "game";
    }
    @GetMapping("/games/new")
    public String createGame(Model model) throws IOException {
        model.addAttribute("game", new GameDto());
        return "game-form";
    }

    @PostMapping("/games/new")
    public String postGame(@ModelAttribute("game") GameDto gameDto) {
        System.out.println("Game added.");
        return "game";
    }
}