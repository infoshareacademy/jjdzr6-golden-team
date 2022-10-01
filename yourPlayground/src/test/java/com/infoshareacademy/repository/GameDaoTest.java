package com.infoshareacademy.repository;

import com.infoshareacademy.dto.FindGameDto;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class GameDaoTest {

    @Test
    void findGamesByCriteriaBuilder() {
        //given
        FindGameDto findGameDto = new FindGameDto("Koszykówka",
                "Sport game",
                "Warszawa",
                LocalDate.of(2022, 10, 2));
    }

}