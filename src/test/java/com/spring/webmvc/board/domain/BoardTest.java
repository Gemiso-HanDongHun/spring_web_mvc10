package com.spring.webmvc.board.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void builderTest() {
        Board board = new Board.Builder()
                .title("제목")
                .boardNo(20L)
                .content("dddd")
                .writer("레레레레")
                .build();




    }
}