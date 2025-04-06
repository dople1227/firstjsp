<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시판 목록</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h2>게시판 목록</h2>
        
        <c:if test="${not empty message}">
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                ${message}
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>
        
        <div class="mb-3">
            <a href="/board/create" class="btn btn-primary">게시물 작성</a>
        </div>
        
        <div class="mb-3">
            <form action="/board/search" method="get" class="form-inline">
                <select name="type" class="form-control mr-2">
                    <option value="title">제목</option>
                    <option value="author">작성자</option>
                </select>
                <input type="text" name="keyword" class="form-control mr-2" placeholder="검색어를 입력하세요">
                <button type="submit" class="btn btn-secondary">검색</button>
            </form>
        </div>
        
        <table class="table table-bordered table-hover">
            <thead class="thead-dark">
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>작성일</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="board" items="${boards}">
                    <tr>
                        <td>${board.id}</td>
                        <td><a href="/board/view/${board.id}">${board.title}</a></td>
                        <td>${board.author}</td>
                        <td>${board.createdDate}</td>
                    </tr>
                </c:forEach>
                <c:if test="${empty boards}">
                    <tr>
                        <td colspan="4" class="text-center">게시물이 없습니다.</td>
                    </tr>
                </c:if>
            </tbody>
        </table>
    </div>
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
