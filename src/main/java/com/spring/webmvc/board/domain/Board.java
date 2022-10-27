package com.spring.webmvc.board.domain;

import lombok.*;

import java.util.Date;

// DB 엔터티(테이블)과 1:1 매칭되는 Value Object

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

//@Data  // 를 사용하면 위의 5가지를 한번에 정의하게 된다. 하지만, 위에서 개별적으로 사용하고 싶을땐 문제가 생긴다
public class Board {

    /*   대문자 Long은 객체타입
         필드에서 봤을때는 기본값 차이이다.
         Long = null, long = 0 이 기본값이다
         넘어오지 않았을때 처리를 위해 Integer 를 사용한다 */

    private Long boardNo;
    private String writer;
    private String content;
    private String title;
    private int viewCnt;
    private Date regDate;

}
