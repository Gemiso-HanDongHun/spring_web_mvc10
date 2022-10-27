package com.spring.webmvc.board.repository;

import com.spring.webmvc.board.domain.Board;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*; // 여기를 해주지 않으면 Assertions.assertEquals 이런식으로 표기해야함

//import static java.lang.Math.random;
// 이렇게 선언해두면 random 메서드를 사용할 때 Math.random(); 이 아닌 그냥 random(); 이런식을 사용이 가능하다

import static java.lang.Math.*;
// * 를 하면 모든 Math 메서드에 대하여 Math를 붙이지 않겠다는 의미

// 테스트시 스프링의 컨테이너를 사용할 것임
// => 의존객체를 스프링에게 주입받아 사용할 것이다

@SpringBootTest
class BoardRepositoryTest {

    // junit5부터는 모든 제한자를 디폴트제한으로 설정한다
    // 필드주입을 사용해야 한다
    @Autowired
    BoardRepository repository;  // 스프링에게 객체를 넣어달라고 하는 것

    @Test
    void bulkInsert() {
        for (int i = 1; i < 300; i++) {    // fori + Enter --> for문 기본문 생성
            Board b = new Board();
            b.setTitle("꿀꿀이" + i);
            b.setContent("아아아" + i);
            b.setWriter("아아아" + (300 - i));

            repository.save(b);
        }


    }

    // 테스트에선 단언이라는 말을 많이 사용한다
    // 단언(Assertion) - 강하게 주장하다는 의미로 확신한다는 말을 하는 것

    @Test
    @DisplayName("300건 게시글을 조회했을때 제목이 꿀꿀이 300이어야 한다")
    void findOneTest() {

        // given : 테스트시 주어지는 변동 데이터
        Long boardNo = 299L;

        // when : 테스트 실제 상황
        Board board = repository.findOne(boardNo);

        // then : 테스트 예상 결과  // 단언한 것 // 실제 조회한 제목
        assertEquals("꿀꿀이299", board.getTitle());
        assertTrue(board.getViewCnt() == 0);
        assertNotEquals("대길이200", board.getWriter());
    }

    @Test
    @DisplayName("전체 게시물을 조회했을 때 리스트의 크기가 299이어야 한다")
    void findAllTest() {
        // given

        // when
        List<Board> boardList = repository.findAll();
        for (Board board : boardList) {
            System.out.println(board);
        }

        // then
        assertEquals(299, boardList.size());

    }

    // Ctrl + E --> 를 통해 최근에 열어봤던(편집했던) 클래스를 볼 수 있다. (쉽게 이동 가능)
    @Test
    @DisplayName("298번의 글제목을 루미너스, 내용을 최강캐로 수정해야 한다")
    @Transactional
    @Rollback
    void modifyTest() {

        // given
        Board board = new Board();
        board.setBoardNo(298L);
        board.setTitle("루미너스");
        board.setContent("최강캐");

        // when
        boolean flag = repository.modify(board);
        Board foundBoard = repository.findOne(board.getBoardNo());

        // then
        assertTrue(flag);
        assertEquals("루미너스", foundBoard.getTitle());
        assertEquals("최강캐", foundBoard.getContent());
    }

    @Test
    @DisplayName("299번 게시물을 삭제하고 다시 조회했을 때 Null 값이 나와야 한다")
    @Transactional
    @Rollback
    void removeTest() {
        // given
        Long boardNo = 299L;

        // when
        boolean flag = repository.remove(boardNo);
        Board board = repository.findOne(boardNo);

        // then
        assertTrue(flag);
        assertNull(board);

    }
}





















