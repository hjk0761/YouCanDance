<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<title>수업 정보 등록</title>
	<link href="${path}/resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div>
		<jsp:include page="../Header.jsp" />
    </div>
	<h2>정보 등록</h2>
	<div class="menu" >
       	<ul>
       		<li><a href="<c:url value='/register/studio'/>">Studio</a></li>
       		<li></li>
       		<li><a href="<c:url value='/register/instructor'/>">Instructor</a></li>
       		<li></li>
       		<li><a href="<c:url value='/register/classes'/>">Class</a></li>
   		</ul>
    </div>
</body>
</html>