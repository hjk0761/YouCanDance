<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<title>스튜디오 등록</title>
	<link href="${path}/resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div>
		<jsp:include page="../Header.jsp" />
    </div>
	<h2>스튜디오 등록</h2>
	<form:form action="studio" modelAttribute="studioRegisterRequest">
	<p>
		<label>이름:<br>
		<form:input placeholder="이름" path="name" />
		<form:errors path="name" />
		</label>
	</p>
	<p>
		<label>위치:<br>
		
		<form:input type="text" id="roadAddress" placeholder="주소" readonly="true" path="locate" />
		<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기">
		<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
		<script>
		    function execDaumPostcode() {
		        new daum.Postcode({
		            oncomplete: function(data) {
		                var roadAddr = data.roadAddress; // 도로명 주소 변수
		                var extraRoadAddr = ''; // 참고 항목 변수
		
		                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
		                    extraRoadAddr += data.bname;
		                }
		                if(data.buildingName !== '' && data.apartment === 'Y'){
		                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
		                }
		                if(extraRoadAddr !== ''){
		                    extraRoadAddr = ' (' + extraRoadAddr + ')';
		                }
		                document.getElementById("roadAddress").value = roadAddr + extraRoadAddr;
		
		                var guideTextBox = document.getElementById("guide");
		                if(data.autoRoadAddress) {
		                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
		                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
		                    guideTextBox.style.display = 'block';
		
		                } else if(data.autoJibunAddress) {
		                    var expJibunAddr = data.autoJibunAddress;
		                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
		                    guideTextBox.style.display = 'block';
		                } else {
		                    guideTextBox.innerHTML = '';
		                    guideTextBox.style.display = 'none';
		                }
		            }
		        }).open();
		    }
		</script>
		<form:errors path="locate" />
		</label>
	</p>
	<p>
		<label>정보:<br>
		<form:input path="info" placeholder="정보"/>
		</label>
	</p>
	<input type="submit" value="전송" />
	</form:form>
</body>
</html>