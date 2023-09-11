<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<title>강사 등록</title>
	<link href="${path}/resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div>
		<jsp:include page="../Header.jsp" />
    </div>
	<h2>강사 등록</h2>
	<form:form action="instructor" modelAttribute="instructorRegisterRequest">
	<p>
		<label>이름:<br>
		<form:input path="name" placeholder="이름"/>
		<form:errors path="name" />
		</label>
	</p>
	<p>
		<label>소속:<br>
		<form:input path="studio_name" readonly="true" placeholder="소속"/>
		<form:input path="studio_id" name="studio_id" type="hidden" />
		<form:button class="studio_id_btn">학원 선택</form:button>
		<form:errors path="studio_name" />
		</label>
	</p>
	<input type="submit" value="전송" />
	<script>
		$('.studio_id_btn').on("click",function(e){
		
		e.preventDefault();
		
		let popUrl = "studioPop";
		let popOption = "width = 650px, height=550px, top=300px, left=300px, scrollbars=yes";
		
		window.open(popUrl,"스튜디오 찾기",popOption);	
		
	});
	</script>
	</form:form>
</body>
</html>