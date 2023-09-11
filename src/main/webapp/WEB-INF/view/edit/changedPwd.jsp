<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<title><spring:message code="change.pwd.title" /></title>
	<link href="${path}/resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div>
		<jsp:include page="../Header.jsp" />
    </div>		
	<p>
		<spring:message code="change.pwd.done" />
	</p>
	<p><a href="<c:url value='/main'/>">[<spring:message code="go.main" />]</a></p>
</body>
</html>