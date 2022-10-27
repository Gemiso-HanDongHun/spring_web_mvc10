package com.spring.webmvc.board.controller;

import com.spring.webmvc.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor    // 주입을 위해 생성자를 만든다
@Controller
@RequestMapping("/board")   // 공통 URL 진입점 설정
public class BoardController {

    private final BoardService service;
    
    // 게시물 목록 조회 요청 처리

}
