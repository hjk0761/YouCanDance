<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<title>YouCanDance</title>
	<link href="${path}/resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div>
		<jsp:include page="Header.jsp" />
    </div>
	<p>
		YouCanDance는 다양한 사람들이 춤에 더 쉽게 접근할 수 있도록 수업을 찾고, 의견을 공유하기 위해 만들어졌습니다.<br>
		지역, 장르, 통일된 난이도로 수업을 찾고 신청해보세요!<br>
		<b>너도 춤, 출 수 있어!</b><br><br>
	</p>
	<p>
		난이도 구분 기준은 다음과 같습니다.<br>
		Basic - 리듬, 박자, 간단한 동작 등을 배우는 수업, 처음 춤을 시작한 사람들을 위한 수업<br>
		Beginner - 쉬운 난이도에서 해당 장르에 입문해보고 싶은 사람들을 위한 수업<br>
		Intermediate - 기본적인 동작을 할 수 있고, 더 많은 움직임을 배우고 싶은 사람들을 위한 수업<br>
		Master - 춤을 창작하거나, 새로운 움직임을 탐구하는 사람들을 위한 수업<br>
		Pop-up - 외부 강사가 진행하는 수업
	</p>
</body>
</html>