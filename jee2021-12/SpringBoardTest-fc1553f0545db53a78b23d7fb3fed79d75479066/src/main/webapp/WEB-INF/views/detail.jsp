<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class="container-fluid">
<%--    ㅈ목--%>
    <div class="row mt-4">
        <div class="col-md-10 offset-md-1">
            <h1>${board.title}</h1>
            <h2 class="text-secondary">${board.writer}</h2>
        </div>
    </div>

    <div class="row mt-4">
        <div class="col-md-10 offset-md-1">
            <div class="row">
                <div class="col-6 text-start">
                    <i class="fa-solid fa-eye"></i> <span class="ms-1">${board.readcount}</span>
                    <span class="ms-4 text-secondary"><fmt:formatDate value="${board.writeTime}" pattern="y년 M월 d일 E a h시 m분 s초"/></span>

                </div>
                <div class="col-6 text-end">
                    <i class="ms-2 fa-solid fa-bookmark"></i>
                    <i class="ms-2 fa-solid fa-share-from-square"></i>
                    <i class="ms-2 fa-light fa-share-nodes"></i>
                </div>
            </div>
        </div>
    </div>

    <hr>

<%--    게시글 내용--%>
    <div class="row mt-4" style="min-height: 350px">
        <div class="col-md-10 offset-md-1">
            <pre>${board.content}</pre>
        </div>
    </div>

    <hr>

<%--    버튼 영역--%>
    <div class="row mt-4">
        <div class="col-md-10 offset-md-1 text-end">
            <a href="write" class="btn btn-primary">글쓰기</a>
            <a href="write" class="btn btn-success">답글쓰기</a>
            <a href="edit?no=${board.no}" class="btn btn-warning">수정</a>
            <a href="delete?no=${board.no}" class="btn btn-danger">삭제</a>
            <a href="./" class="btn btn-dark">목록</a>
        </div>
    </div>
<%--댓글 영역--%>
    <div class="row mt-4">
        <div class="col-md-10 offset-md-1">
            5,000개의 댓글이 있습니다.
        </div>
    </div>

    <div class="row mt-4">
        <div class="col-md-10 offset-md-1">
            <form action="??" method="post">
                <textarea name="?" class="form-control" rows="4" style="resize: none"></textarea>
                <button type="submit" class="btn btn-primary w-100 mt-3">등록</button>
            </form>
        </div>
    </div>

    <div class="row mt-4">
        <div class="col-md-10 offset-md-1">
            <hr>
            <h5 class="text-dark">작성자</h5>
            <h6 class="text-secondary">
                ?분 전
                <i class="ms-4 fa-solid fa-thumbs-up text-danger"></i>
                <span class="text-danger">500</span>
            </h6>
            <pre class="mt-3" style="min-height: 75px;" >테스트 댓글 영역</pre>
        </div>
    </div>

    <div class="row mt-4">
        <div class="col-md-10 offset-md-1">
            <hr>
            <h5 class="text-dark">작성자</h5>
            <h6 class="text-secondary">
                ?분 전
                <i class="ms-4 fa-solid fa-thumbs-up text-danger"></i>
                <span class="text-danger">500</span>
            </h6>
            <pre class="mt-3" style="min-height: 75px;" >테스트 댓글 영역</pre>
        </div>
    </div>

    <div class="row mt-4">
        <div class="col-md-10 offset-md-1">
            <hr>
            <h5 class="text-dark">작성자</h5>
            <h6 class="text-secondary">
                ?분 전
                <i class="ms-4 fa-solid fa-thumbs-up text-danger"></i>
                <span class="text-danger">500</span>
            </h6>
            <pre class="mt-3" style="min-height: 75px;" >테스트 댓글 영역</pre>
        </div>
    </div>

</div>



<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
