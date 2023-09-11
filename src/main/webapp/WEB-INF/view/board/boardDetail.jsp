<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<title>글 읽기</title>
	<link href="${path}/resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div>
		<jsp:include page="../Header.jsp" />
    </div>
	<p>아이디: ${board.id}</p>
	<p>조회수: ${board.readCount}</p>
	<p>작성자: ${board.name}</p>
	<p>작성일: <tf:formatDateTime value="${board.regdate}" pattern="yyyy-MM-dd-HH:mm" /></p>
	<p>제목: ${board.subject}</p>
	<p>내용: ${board.content}</p>
	
	<a href="<c:url value="/board/list" />">[목록]</a>
	
</body>
</html>