package com.spring.webmvc.board.service;

import com.spring.webmvc.board.domain.Board;
import com.spring.webmvc.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 역할 : 컨트롤러와 리파지토리 사이 중간에서 잡다한 처리를 담당

@RequiredArgsConstructor  // final 필드 초기화 생성자를 만듦 // 주입을 위해 생성자를 만든다
@Service
public class BoardService {

    // Setter를 사용시 값 변경이 가능하므로 private final을 사용하여 값 변경이 불가하도록 한다(안전한 방법)
    private final BoardRepository repository;

    // 전체조회 중간처리
    public List<Board> getList() {
        List<Board> boardList = repository.findAll();
        return boardList;
    }

    // 상세 조회 중간처리
    public Board getDetail(Long boardNo) {
        Board board = repository.findOne(boardNo);
        return board;
    }

    // 게시물 저장 중간처리
    public boolean insert(Board board) {
        boolean flag = repository.save(board);
        return flag;
    }

    // 게시물 수정 중간처리
    public boolean update(Board board) {
        boolean flag = repository.modify(board);
        return flag;
    }

    // 게시물 삭제 중간처리
    public boolean delete(Long boardNo) {
        boolean flag = repository.remove(boardNo);
        return flag;
    }
}


//    @Autowired
//    public BoardService(BoardRepository repository) {   // final을 건뒤 생성자 주입을 한다
//        this.repository = repository;
//    }


// set + Enter  :  자동으로 생성됨