package com.spring.webmvc.board.domain;

import lombok.*;

import java.util.Date;

// DB 엔터티(테이블)과 1:1 매칭되는 Value Object

@Setter
@Getter
@ToString
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

    // 커스텀 필드
    private String shortTitle; // 커서를 올려놨을때 줄임 제목 보여주기
    private String prettierDate; // 포멧팅한 날짜문자열
    private boolean newArticle; // 신규게시물 여부    ---> 맞으면 true 틀리면 false

    private Board(Builder builder){
        this.boardNo = builder.boardNo;
        this.writer = builder.writer;
        this.content = builder.content;
        this.title = builder.title;
        this.viewCnt = builder.viewCnt;
        this.regDate = builder.regDate;
    }


    // 내부 클래스로 Builder 라는 클래스를 생성
    public static class Builder {
        private Long boardNo;
        private String writer;
        private String content;
        private String title;
        private int viewCnt;
        private Date regDate;

        public Builder boardNo(Long boardNo) {
            this.boardNo = boardNo;
            return this;
        }

        public Builder writer(String writer) {
            this.writer = writer;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder viewCnt(int viewCnt) {
            this.viewCnt = viewCnt;
            return this;
        }

        public Builder regDate(Date regDate) {
            this.regDate = regDate;
            return this;
        }

        public Board build() {
            return new Board(this);
        }
    }
}
