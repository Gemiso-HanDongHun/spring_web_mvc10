<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <%@ include file="../include/static-head.jspf" %>

    <style>
        .write-container {
            width: 50%;
            margin: 200px auto 150px;
            font-size: 1.2em;
        }
    </style>
</head>

<body>
<div class="wrap">
    <%@ include file="../include/header.jspf" %>

    <div class="write-container">

        <form id="write-form" action="/board/write" method="post" autocomplete="off">    <%-- 등록 요청이므로 Post 방식 --%>

            <div class="mb-3">
                <label for="writer-input" class="form-label">작성자</label>
                <input type="text" class="form-control" id="writer-input" placeholder="이름"
                       name="writer" maxlength="20">
            </div>

            <div class="mb-3">
                <label for="title-input" class="form-label">글제목</label>
                <input type="text" class="form-control" id="title-input" placeholder="제목" name="title">
            </div>

            <div class="mb-3">
                <label for="exampleFormControlTextarea1" class="form-label">내용</label>
                <textarea name="content" class="form-control" id="exampleFormControlTextarea1" rows="10"></textarea>
            </div>

            <div class="d-grid gap-2">
                <button id="reg-btn" class="btn btn-dark" type="button">글 작성하기</button>
                <button id="to-list" class="btn btn-warning" type="button">목록으로</button>
            </div>

        </form>

    </div>

    <%@ include file="../include/footer.jspf" %>

</div>

<script>

    // 게시물 등록 입력값 검증 함수
    function validateFormValue() {
        // 이름입력태그, 제목 입력태그
        const $writerInput = document.getElementById('writer-input');
        const $titleInput = document.getElementById('title-input');
        let flag = false; // 입력 제대로하면 true로 변경

        console.log('w: ', $writerInput.value);
        console.log('t: ', $titleInput.value);

        if ($writerInput.value.trim() === '') {
            alert('작성자는 필수값입니다~');
        } else if ($titleInput.value.trim() === '') {
            alert('제목은 필수값입니다~');
        } else {
            flag = true;
        }

        console.log('flag:', flag);

        return flag;
    }

    // 게시물 입력값 검증
    const $regBtn = document.getElementById('reg-btn');

    $regBtn.onclick = e => {
        // 입력값을 제대로 채우지 않았는지 확인
        if (!validateFormValue()) {
            return;
        }

        // 필수 입력값을 잘 채웠으면 폼을 서브밋한다.
        const $form = document.getElementById('write-form');
        $form.submit();
    };


    //목록버튼 이벤트
    const $toList = document.getElementById('to-list');
    $toList.onclick = e => {
        location.href = '/board/list';
    };
</script>

</body>

</html>