package com.spring.webmvc.board.service;

import com.spring.webmvc.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 역할 : 컨트롤러와 리파지토리 사이 중간에서 잡다한 처리를 담당

@RequiredArgsConstructor  // final 필드 초기화 생성자를 만듦
@Service
public class BoardService {


    // Setter를 사용시 값 변경이 가능하므로 private final을 사용하여 값 변경이 불가하도록 한다(안전한 방법)
    private final BoardRepository repository;


//    @Autowired
//    public BoardService(BoardRepository repository) {   // final을 건뒤 생성자 주입을 한다
//        this.repository = repository;
//    }
}




// set + Enter  :  자동으로 생성됨