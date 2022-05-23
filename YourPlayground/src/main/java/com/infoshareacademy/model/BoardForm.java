package com.infoshareacademy.model;

import com.infoshareacademy.service.FormService;
import com.infoshareacademy.service.FormServiceImpl;

public class BoardForm extends FormServiceImpl {
    public BoardForm(Game game) {
        super(game);
    }
}
