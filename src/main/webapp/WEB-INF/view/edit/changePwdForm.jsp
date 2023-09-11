<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<form:form>
	<p>
		<label><spring:message code="currentPassword" />:<br>
		<form:input path="currentPassword" />
		<form:errors path="currentPassword" />
		</label>
	</p>
	<p>
		<label><spring:message code="newPassword" />:<br>
		<form:password path="newPassword" />
		<form:errors path="newPassword" />
		</label>
	</p>
	<input type="submit" value="<spring:message code="change.btn" />">
	</form:form>
</body>
</html>