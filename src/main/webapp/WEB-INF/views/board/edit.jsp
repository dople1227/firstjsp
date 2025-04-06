<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시물 수정</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
    <div class="container mt-4">
        <h2>게시물 수정</h2>
        
        <form:form action="/board/edit/${boardId}" method="post" modelAttribute="boardRequest">
            <div class="form-group">
                <label for="title">제목</label>
                <form:input path="title" class="form-control" id="title" />
                <form:errors path="title" cssClass="error" />
            </div>
            <div class="form-group">
                <label for="author">작성자</label>
                <form:input path="author" class="form-control" id="author" readonly="true" />
                <form:errors path="author" cssClass="error" />
            </div>
            <div class="form-group">
                <label for="content">내용</label>
                <form:textarea path="content" class="form-control" id="content" rows="10" />
                <form:errors path="content" cssClass="error" />
            </div>
            <button type="submit" class="btn btn-primary">저장하기</button>
            <a href="/board/view/${boardId}" class="btn btn-secondary">취소</a>
        </form:form>
    </div>
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>