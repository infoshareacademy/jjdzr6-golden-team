package com.infoshareacademy.controller;

import com.infoshareacademy.dto.*;
import com.infoshareacademy.exceptions.GameNotFoundException;
import com.infoshareacademy.exceptions.PlayerNotFoundException;
import com.infoshareacademy.service.GameService;
import com.infoshareacademy.service.PlayerService;
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
import java.util.List;

@Controller
@RequestMapping("games")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GameController {


    private final GameService gameService;

    private final PlayerService playerService;

    @GetMapping("{id}")
    public String getGame(@PathVariable Integer id, Model model) throws GameNotFoundException {
        model.addAttribute("game", gameService.findById(id));
        return "game";
    }

    @GetMapping
    public String getGames(Model model) {
        model.addAttribute("findGame", new FindGameDto());
        model.addAttribute("games", gameService.findAll());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        model.addAttribute("player", playerService.findByUsername(authentication.getName()));

        return "games";
    }

   @PostMapping("find")
    public String findGames(@Valid @ModelAttribute("findGame") FindGameDto findGameDto,
                                BindingResult bindingResult, Model model) {
        List<GameDto> foundGames = gameService.findByCriteriaBuilder(findGameDto);
        model.addAttribute("foundGames", foundGames);

       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       model.addAttribute("player", playerService.findByUsername(authentication.getName()));

        if (bindingResult.hasErrors()) {
            return "games";
        }
        return "foundGames";
    }

    @GetMapping("new")
    public String createGame(Model model) {
        model.addAttribute("game", new CreateGameDto());
        return "game-form";
    }

    @Secured("ROLE_USER")
    @PostMapping("new")
    public String postGame(@Valid @ModelAttribute("game") CreateGameDto createGameDto,
                           BindingResult bindingResult) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PlayerDto gameOwnerDto = playerService.findByUsername(authentication.getName());
        createGameDto.setGameOwner(gameOwnerDto);

        if(bindingResult.hasErrors()) {
            return "game-form";
        }

        gameService.create(createGameDto);
        return "redirect:/games";
    }

    @Secured("ROLE_USER")
    @GetMapping("join/{id}")
    public String joinGame(@PathVariable Integer id, @Valid @ModelAttribute("game") JoinGameDto joinGameDto) throws GameNotFoundException, PlayerNotFoundException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PlayerDto player = playerService.findByUsername(authentication.getName());

        gameService.joinGame(joinGameDto, player);
        return "redirect:/games";
    }

    @Secured("ROLE_USER")
    @GetMapping("delete/{id}")
    public String deleteGame(@PathVariable Integer id) {
        gameService.deleteGame(id);
        return "redirect:/games";
    }

}