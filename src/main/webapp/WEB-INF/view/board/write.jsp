<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	<h2>글 작성</h2>
	<form:form action="write" modelAttribute="boardWriteRequest">
	<p>
		<label>제목:<br>
		<form:input path="subject" placeholder="제목"/>
		<form:errors path="subject" />
		</label>
	</p>
	<p>
		<label>이름:<br>
		<c:if test="${empty authInfo}">
			<form:input value="Guest" path="name" readonly="true" />
		</c:if>
		<c:if test="${! empty authInfo}">
			<form:input path="name" value="${authInfo.name }" readonly="true" />
		</c:if>
		<form:errors path="name" />
		</label>
	</p>
	<p>
		<label>내용:<br>
		<form:input path="content" placeholder="내용"/>
		<form:errors path="content" />
		</label>
	</p>
	<input type="submit" value="등록">
	</form:form>
</body>
</html>