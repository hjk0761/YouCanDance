<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<title>회원 정보</title>
	<link href="${path}/resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div>
		<jsp:include page="../Header.jsp" />
    </div>
	<p>아이디: ${member.id}</p>
	<p>이메일: ${member.email}</p>
	<p>이름: ${member.name}</p>
	<p>가입일: <tf:formatDateTime value="${member.registerDateTime}" pattern="yyyy-MM-dd-HH:mm" /></p>
	<p><a href="<c:url value="/edit/changePassword" />">[비밀번호 변경]</a></p>
</body>
</html>