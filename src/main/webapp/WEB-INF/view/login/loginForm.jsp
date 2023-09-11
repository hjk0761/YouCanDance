<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<title><spring:message code="login.title" /></title>
	<link href="${path}/resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div>
		<jsp:include page="../Header.jsp" />
    </div>
	<form:form modelAttribute="loginCommand">
	<form:errors />
	<p>
		<label><spring:message code="email" />:<br>
		<form:input path="email" placeholder="이메일" />
		<form:errors path="email" />
		</label>
	</p>
	<p>
		<label><spring:message code="password" />:<br>
		<form:password path="password" placeholder="비밀번호" />
		<form:errors path="password" />
		</label>
	</p>
	<p>
		<label><spring:message code="rememberEmail" />:<br>
		<form:checkbox path="rememberEmail" />
		</label>
	</p>
	<input type="submit" value="<spring:message code="login.btn" />">
	</form:form>
</body>
</html>