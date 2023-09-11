<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<title>수업 찾기</title>
	<link href="${path}/resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div>
		<jsp:include page="../Header.jsp" />
    </div>
    <div>
		<h2>수업 목록</h2>
		<h3>등록된 수업 수: ${count}</h3>
		<form>
			<select name="search_category">
				<option value="studio_name">학원 이름</option>
				<option value="studio_locate">학원 위치</option>
				<option value="instructor_name">강사 이름</option>
				<option value="genre">장르</option>
				<option value="difficulty">난이도</option>
			</select>
			<input type="text" name="search_keyword" placeholder="검색어 입력">
			<input type="submit" value="검색하기">
		</form>
		<br>
		<form:form modelAttribute="listCommand">
			<label>시작 시간: <form:input path="from" placeholder="yyyyMMddHH" /></label>
			~
			<label>종료 시간: <form:input path="to" placeholder="yyyyMMddHH" /></label>
			<input type="submit" value="검색하기">
		</form:form>
		<br>
		<table>
			<thead>
				<tr>
					<th style="width:7%;">학원 이름</th>
					<th>학원 위치</th>
					<th>강사 이름</th>
					<th>시작 시간</th>
					<th>종료 시간</th>
					<th>장르</th>
					<th style="width:7%;">난이도</th>
					<th>신청방법</th>
				</tr>
			</thead>
			<c:if test="${empty results }">
			<tbody>
				<c:forEach items="${classInfos}" var="classInfos">
					<tr>
						<td>${classInfos.studio_name}</td>
						<td>${classInfos.studio_locate}</td>
						<td>${classInfos.instructor_name}</td>
						<td><tf:formatDateTime value="${classInfos.start_time}" pattern="yyyy-MM-dd a h:mm" /></td>
						<td><tf:formatDateTime value="${classInfos.end_time}" pattern="yyyy-MM-dd a h:mm" /></td>
						<td>${classInfos.genre}</td>
						<td>${classInfos.difficulty}</td>
						<td>${classInfos.apply}</td>
					</tr>
				</c:forEach>
			</tbody>
			</c:if>
			<c:if test="${!empty results }">
				<c:forEach items="${results}" var="results">
					<tr>
						<td>${results.studio_name}</td>
						<td>${results.studio_locate}</td>
						<td>${results.instructor_name}</td>
						<td><tf:formatDateTime value="${results.start_time}" pattern="yyyy-MM-dd a h:mm" /></td>
						<td><tf:formatDateTime value="${results.end_time}" pattern="yyyy-MM-dd a h:mm" /></td>
						<td>${results.genre}</td>
						<td>${results.difficulty}</td>
						<td>${results.apply}</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</div>
</body>
</html>