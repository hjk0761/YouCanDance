<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<title>게시판</title>
	<link href="${path}/resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div>
		<jsp:include page="../Header.jsp" />
    </div>
    <div>
		<h2>글 목록</h2>
		<h3>총 글 수: ${count}</h3>
		<table>
			<thead>
				<tr>
					<th style="width:7%;">번호</th>
					<th style="width:15%;">제목</th>
					<th>내용</th>
					<th style="width:10%;">작성자</th>
					<th>날짜</th>
					<th style="width:7%;">조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${boards}" var="boards">
					<tr onClick="location.href='<c:url value="/board/${boards.id} " />'" style="cursor:pointer;">
						<td>${boards.id}</td>
						<td>${boards.subject}</td>
						<%--<td><a href="<c:url value="/board/${boards.id} " />">${boards.subject} </a></td>--%>
						<td style="overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${boards.content}</td>
						<td>${boards.name}</td>
						<td><tf:formatDateTime value="${boards.regdate}" pattern="yyyy-MM-dd HH:mm" /></td>
						<td>${boards.readCount}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<a href="<c:url value="/board/write" />">[글쓰기]</a>
	</div>
</body>
</html>