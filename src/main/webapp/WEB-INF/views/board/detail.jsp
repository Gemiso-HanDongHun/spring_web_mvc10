<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <%@ include file="../include/static-head.jspf" %>

    <style>
        .content-container {
            width: 60%;
            margin: 150px auto;
            position: relative;
        }

        .content-container .main-title {
            font-size: 24px;
            font-weight: 700;
            text-align: center;
            border-bottom: 2px solid rgb(75, 73, 73);
            padding: 0 20px 15px;
            width: fit-content;
            margin: 20px auto 30px;
        }

        .content-container .main-content {
            border: 2px solid #ccc;
            border-radius: 20px;
            padding: 10px 25px;
            font-size: 1.1em;
            text-align: justify;
            min-height: 400px;
        }

        .content-container .custom-btn-group {
            position: absolute;
            bottom: -10%;
            left: 50%;
            transform: translateX(-50%);
        }
    </style>
</head>

<body>

<div class="wrap">
    <%@ include file="../include/header.jspf" %>

    <div class="content-container">


        <h1 class="main-title">${b.boardNo}번 게시물</h1>    <%-- 컨트롤러에서 b에 담았기 때문에 b.boardNo 로 사용 --%>

        <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">작성자</label>
            <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="이름" name="writer"
                   value="${b.writer}" disabled>
        </div>
        <div class="mb-3">
            <label for="exampleFormControlInput2" class="form-label">글제목</label>
            <input type="text" class="form-control" id="exampleFormControlInput2" placeholder="제목" name="title"
                   value="${b.title}" disabled>
        </div>
        <div class="mb-3">
            <label for="exampleFormControlTextarea1" class="form-label">내용</label>

            <p class="main-content">
                ${b.content}
            </p>

        </div>

        <div class="btn-group btn-group-lg custom-btn-group" role="group">
            <button id="mod-btn" type="button" class="btn btn-warning">수정</button>
            <button id="del-btn" type="button" class="btn btn-danger">삭제</button>
            <button id="list-btn" type="button" class="btn btn-dark">목록</button>
        </div>

    </div>


    <%@ include file="../include/footer.jspf" %>
</div>


<script>

    const [$modBtn, $delBtn, $listBtn]
        = [...document.querySelector('div[role=group]').children];

    // const $modBtn = document.getElementById('mod-btn');
    //수정버튼
    $modBtn.onclick = e => {
        location.href = '/board/modify?boardNo=${b.boardNo}';
    };

    //삭제버튼
    $delBtn.onclick = e => {
        if (!confirm('정말 삭제하시겠습니까?')) {
            return;
        }
        location.href = '/board/delete?boardNo=${b.boardNo}';
    };

    //목록버튼
    $listBtn.onclick = e => {
        location.href = '/board/list';
    };

</script>

</body>

</html>