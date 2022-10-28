package com.spring.webmvc.board.controller;

import com.spring.webmvc.board.domain.Board;
import com.spring.webmvc.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor    // 주입을 위해 생성자를 만든다
@Controller
@RequestMapping("/board")   // 공통 URL 진입점 설정
@Log4j2  // Lombok 라이브러리
public class BoardController {

    private final BoardService service;

    // 게시물 목록 조회 요청
    // 예전 버전 : @RequestMapping(value = "/list", method = RequestMethod.GET)
    @GetMapping("/list")
    public String list(Model model) {

        int a = 10;
        List<Board> boardList = service.getList();
        log.info("/board/list GET ! 요청 발생 !  {}", a);   // {} 부분에 선언한 a 가 들어온다

        model.addAttribute("bList", boardList);     // 뷰 템플릿에 보내기 위하여 model을 사용한다

        return "board/list";

        /*
            TRACE - 잡다한 자잘한 로그
            DEBUG - 개발단계의 디버깅
            INFO - 정보
            WARN - 심각하진 않지만 경고
            ERROR - 심각한 에러     :: 밑으로 갈수록 중요한 로그이다

         */
    }

    // 게시물 상세 조회 요청 처리
    @GetMapping("/content/{bno}")  // 뒤에 글번호가 붙어서 달라오게되는것.  글번호 : boardNo
    public String content(@PathVariable("bno") Long boardNo, Model model) { // 모델에 담아주기 위해 선언

        log.info("/board/content/{} GET!", boardNo);

        // 박스에 담아서 담아주는데 그 박스가 모델이다
        // Ctrl + Alt + n  : 자동으로 인라인 설정,     나올때는 Ctrl + Alt + v
        model.addAttribute("b", service.getDetail(boardNo));   // 결과를 뷰한테 포워딩을 하면서 보낸다
        return "board/detail";
    }

    // 게시물 쓰기 화면 요청 ( 조회 )
    @GetMapping("/write")
    public String write() {
        log.info("/board/write Get!");
        return "board/write";  // DB에 접근할 필요가 없으므로 바로 포워딩을 한다
    }


    // 게시물 등록 요청
    @PostMapping("/write")  // url이 같아도("/write") 로 현재 같음        @Get, @Post 가 다르므로 구분이 가능하다
    public String write(Board board, RedirectAttributes ra) { //Board 명이랑 table 명이 다르면 DTO를 하나 만들고 BoardDTO 이런식으로 부여
        log.info("/board/write Post!", board);

        boolean flag = service.insert(board);

        ra.addAttribute("msg", "insert-success");
        // 포워드와 redirect의 차이는 결과 적인 측면에서는 둘다 list.jsp를 연다는 것은 동일하지만
        // 포워드는 BoardController가 list.jsp한테 위임하는 건데  요청 한 번 응답 한 번 뿐이다. request 객체 데이터는 한번의 응답과 요청을 수행하면 죽는다.  브라우저가 꺼지면 죽는다
        // redirect는 두번의 요청까지는 msg가 살아있고 그 후에 죽게된다  Model 대신 RedirectAttributes 를 사용하는 이유

        return flag ? "redirect:/board/list" : "redirect:/";   // flag 가 실패시 redirect 성공시 왼쪽으로 이동
        // 성공시에 바로 "board/list"로 포워딩을 하게 되면 안된다.
        // 왜냐면 --->  단순이 지정한 페이지로 가는 것이기때문 (게시물 목록을 들고 가줘야 하는데 즉, List<Board> boardList = service.getList() 를 가져와야하는데
        // 단순히 페이지만 가는 것이므로 재요청이 필요하다.   재요청을 하는 것이 바로 redirect
    }
}