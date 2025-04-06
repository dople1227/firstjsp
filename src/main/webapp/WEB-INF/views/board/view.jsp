<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시물 상세보기</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h2>게시물 상세보기</h2>
        
        <c:if test="${not empty message}">
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                ${message}
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>
        
        <div class="card">
            <div class="card-header">
                <h5>${board.title}</h5>
            </div>
            <div class="card-body">
                <p class="card-text">${board.content}</p>
            </div>
            <div class="card-footer">
                <p>작성자: ${board.author}</p>
                <p>작성일: ${board.formattedCreatedDate}</p>
                <c:if test="${not empty board.formattedModifiedDate}">
                    <p>수정일: ${board.formattedModifiedDate}</p>
                </c:if>
            </div>
        </div>
        
        <div class="mt-3">
            <a href="/board/list" class="btn btn-secondary">목록으로</a>
            <a href="/board/edit/${board.id}" class="btn btn-primary">수정하기</a>
            <form action="/board/delete/${board.id}" method="post" style="display: inline-block;">
                <button type="submit" class="btn btn-danger" onclick="return confirm('정말로 삭제하시겠습니까?');">삭제하기</button>
            </form>
        </div>
    </div>
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
