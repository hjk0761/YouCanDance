<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<title>회원 조회</title>
	<link href="${path}/resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form:form modelAttribute="cmd">
	<p>
		<label>from: <form:input path="from" /></label>
		<form:errors path="from" />
		~
		<label>to: <form:input path="to" /></label>
		<form:errors path="to" />
		<input type="submit" value="조회">
	</p>
	</form:form>
	
	<c:if test="${! empty members }">
	<table>
		<tr>
			<tr>아이디</tr><tr>이메일</tr>
			<tr>이름</tr><tr>가입일</tr>
		</tr>
		<c:forEach var="mem" items="${members}">
		<tr>
			<td>${mem.id}</td>
			<td><a href="<c:url value="/members/${mem.id}"/>">
				${mem.email}</a></td>
			<td>${mem.name}</td>
			<td><tf:formatDateTime value="${mem.registerDateTime }" pattern="yyyy-MM-dd" /></td>
		</tr>
		</c:forEach>
	</table>
	</c:if>
</body>
</html>