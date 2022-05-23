package com.infoshareacademy.model;

import com.infoshareacademy.service.FormService;
import com.infoshareacademy.service.FormServiceImpl;

public class SportForm extends FormServiceImpl {
    public SportForm(Game game) {
        super(game);
    }
}
