<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<title>학원 찾기 팝업</title>
	<link href="${path}/resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div>
		<h2>강사 찾기</h2>
		<h3>총 강사 수: ${count}</h3>
		<table>
			<thead>
				<tr>
					<th>이름</th>
					<th>소속</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${instructors}" var="instructors">
					<tr>
						<td>
							<a class="move" href='<c:out value="${instructors.id}"/>' data-name='<c:out value="${instructors.name}"/>'>
							${instructors.name}
							</a>
						</td>
						<td>${instructors.studio_id}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script>
	$(".move").on("click", function(e){
		
		e.preventDefault();
		
		let instructorId = $(this).attr("href");
		let instructorName= $(this).data("name");
		$(opener.document).find("#instructor_id").val(instructorId);
		$(opener.document).find("#instructor_name").val(instructorName);
		
		window.close();

	});	
	</script>
</body>
</html>