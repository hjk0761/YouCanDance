<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<title>수업 등록</title>
	<link href="${path}/resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div>
		<jsp:include page="../Header.jsp" />
    </div>		
	<h2>수업 등록</h2>
	<form:form action="classes" modelAttribute="classesRegisterRequest">
	<p>
		<label>학원 이름:<br>
		<form:input path="studio_name" readonly="true" placeholder="학원 이름"/>
		<form:input path="studio_id" name="studio_id" type="hidden" />
		<form:button class="studio_id_btn">학원 선택</form:button>
		<form:errors path="studio_name" />
		</label>
	</p>
	<p>
		<label>강사 이름:<br>
		<form:input path="instructor_name" readonly="true" placeholder="강사 이름"/>
		<form:input path="instructor_id" name="instructor_id" type="hidden" />
		<form:button class="instructor_id_btn">강사 선택</form:button>
		<form:errors path="instructor_name" />
		</label>
	</p>
	<p>
		<label>시작 시간:<br>
		<form:input path="start_time" type="datetime-local" />
		<form:errors path="start_time" />
		</label>
	</p>
	<p>
		<label>종료 시간:<br>
		<form:input path="end_time" type="datetime-local" />
		<form:errors path="end_time" />
		</label>
	</p>
	<p>
		<label>장르:<br>
		<form:select path="genre">
			<option value=""></option>
			<option value="Street">Street</option>
			<option value="Popping">&emsp;Popping</option>
			<option value="Locking">&emsp;Locking</option>
			<option value="Waacking">&emsp;Waacking</option>
			<option value="Hiphop">&emsp;Hiphop</option>
			<option value="Urban">&emsp;Urban</option>
			<option value="Breaking">&emsp;Breaking</option>
			<option value="K-pop">K-pop</option>
			<option value="Choreography">Choreography</option>
			<option value="Disco">Disco</option>
			<option value="Punk">Choreography</option>
			<option value="Jazz">Jazz</option>
			<option value="Swing">Swing</option>
			<option value="Others">Others</option>
		</form:select>
		<form:errors path="genre" />
		</label>
	</p>
	<p>
		<label>난이도:<br>
		<form:select path="difficulty">
			<option value="Basic">Basic</option>
			<option value="Beginner">Beginner</option>
			<option value="Intermediate">Intermediate</option>
			<option value="Master">Master</option>
			<option value="Pop-up">Pop-up</option>
		</form:select>
		<form:errors path="difficulty" />
		</label>
	</p>
	<p>
		<label>신청 방법:<br>
		<form:input path="apply" placeholder="신청 방법" />
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
		
		$('.instructor_id_btn').on("click",function(e){
			
			e.preventDefault();
			
			let popUrl = "instructorPop";
			let popOption = "width = 650px, height=550px, top=300px, left=300px, scrollbars=yes";
			
			window.open(popUrl,"강사 찾기",popOption);	
			
			});
	</script>
	</form:form>
</body>
</html>