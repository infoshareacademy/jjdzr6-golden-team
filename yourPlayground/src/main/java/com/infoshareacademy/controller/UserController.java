package com.infoshareacademy.controller;

import com.infoshareacademy.service.FormServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    FormServiceImpl formService;

    @GetMapping(path = "/api/games", produces = "application/json")
    public String userList() throws IOException {
        return formService.printGamesFromJsonStr().toString();
    }
}
