package com.spring.webmvc.board.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void builderTest() {
        Board.builder()
                .title("제목")
                .boardNo(20L)
                .content("dddd")
                .build();
    }
}