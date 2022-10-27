package com.spring.webmvc.board.repository;

import com.spring.webmvc.board.domain.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// 역할 : 데이터를 저장, 조회, 수정, 삭제하는 책임을 부여받음
// SQL Mapper 인터페이스
@Mapper
public interface BoardRepository {
    
    // 게시글 목록 조회
    List<Board> findAll();  // Alt + Enter : import

    // 게시글 상세 단일 조회
    Board findOne(Long boardNo);

    // 게시글 쓰기
    boolean save(Board board);  // boolean -> 성공, 실패 느낌으로

    // 게시글 삭제
    boolean remove(Long boardNo);   // 번호를 기준으로 삭제하므로

    // 게시글 수정
    boolean modify(Board board);  // 게시글 쓰는것과 동일하게 읽기, 쓰기 전부 가지고 있는 Board를 매개변수로 받는다
}

// Ctrl + Shift + T    -->   새로운 테스트 생성