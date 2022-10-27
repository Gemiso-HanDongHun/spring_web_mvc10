package com.spring.webmvc.board.repository;

import com.spring.webmvc.board.domain.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

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
}