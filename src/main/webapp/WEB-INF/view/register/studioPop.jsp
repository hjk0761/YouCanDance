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
		<h2>학원 찾기</h2>
		<h3>총 학원 수: ${count}</h3>
		<table>
			<thead>
				<tr>
					<th>이름</th>
					<th>위치</th>
					<th>정보</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${studios}" var="studios">
					<tr>
						<td>
							<a class="move" href='<c:out value="${studios.id}"/>' data-name='<c:out value="${studios.name}"/>'>
							${studios.name}
							</a>
						</td>
						<td>${studios.locate}</td>
						<td>${studios.info}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script>
	$(".move").on("click", function(e){
		
		e.preventDefault();
		
		let studioId = $(this).attr("href");
		let studioName= $(this).data("name");
		$(opener.document).find("#studio_id").val(studioId);
		$(opener.document).find("#studio_name").val(studioName);
		
		window.close();

	});	
	</script>
</body>
</html>