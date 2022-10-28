package com.spring.webmvc.board.service;

import com.spring.webmvc.board.domain.Board;
import com.spring.webmvc.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
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
        
        processBoardList(boardList);   // 리펙토링 하는 이유 --> 중간처리를 할때 다른 개발자가 처리하는 부분을 바로 확인할 수 있게 하기 위해

        return boardList;
    }

    private void processBoardList(List<Board> boardList) {
        for (Board b : boardList) {

            // 게시물 제목 줄임 처리
            subStringTitle(b);   // Ctrl + Alt + m   ----->   추출 해서 메서드로 정의

            // 날짜 포멧팅 처리
            convertDateFormat(b);  // Ctrl + Alt + m   ----->   추출 해서 메서드로 정의

            // 신규 게시물 new 마크 처리 (10분 이내 작성된 게시물)
            isNewArticle(b);   // Ctrl + Alt + m   ----->   추출 해서 메서드로 정의
        }
    }

    // 신규 게시물 new 마크 처리 (10분 이내 작성된 게시물)
    private static void isNewArticle(Board b) {
        long regDate = b.getRegDate().getTime(); // 게시물 작성 시간(밀리초)    // getTime() 의 return 은 Long 타입이다
        long nowDate = System.currentTimeMillis(); // 현재 시간 시간(밀리초)

        long diff = nowDate - regDate;  // 작성 후 지난 시간(밀리초)
        long limit = 10 * 60 * 1000; // 10분을 밀리초로 변환

        if (diff <= limit) {
            b.setNewArticle(true);
        }
    }

    // 날짜 포멧팅 처리
    private void convertDateFormat(Board b) {
        Date regDate = b.getRegDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd a hh:mm");
        b.setPrettierDate(sdf.format(regDate));
    }

    // 게시물 제목 줄임 처리
    // 만약에 글제목이 6글자 이상이면 6글자까지만 보여주고 뒤에 ... 처리
    private void subStringTitle(Board b) {
        String title = b.getTitle();
        if (title.length() > 6) {
            String shortTitle = title.substring(0, 6) + "...";
            b.setShortTitle(shortTitle);
        } else {
            b.setShortTitle((title));
        }
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