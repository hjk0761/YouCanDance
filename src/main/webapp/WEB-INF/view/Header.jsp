<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
	<title>상단 영역</title>
	<style>
		li{
			background: inherit;
        	position: relative;
        	display: inline-block;
		}
    	nav{
        	background: black;
       		padding: 10px 0px;
       		height: 40px;
       		text-align: justify;
       		text-justify: distribute;
       		text-coler:white;
		}
      	ul.header{
      		background: inherit;
      		margin:0px;
      		padding:5px 10px;
      		display: flex;
      		justify-content: space-between;
      		list-style-type: none;
      		font-size: 20px;
		}
		ul.login{
			display: flex;
			background: black;
			justify-content: flex-end;
			margin: 0px;
			font-size: 14px;
			color: white;
		}
		a.header{
			background: inherit;
			text-decoration: none;
			color: white;
		}
		a.login{
			color: white;
		}
      </style>
</head>
<body>
	<c:if test="${! empty authInfo}">
		<ul class="login">
			<li class="login">${authInfo.name}님, 환영합니다.</li>
			<li>&nbsp;&nbsp;&nbsp;&nbsp;</li>
			<li class="login"><a class="login" href="<c:url value="/logout" />"><b>로그아웃</b></a></li>
			<li>&nbsp;&nbsp;&nbsp;&nbsp;</li>
		</ul>
	</c:if>
	<c:if test="${empty authInfo}">
		<ul class="login">
			<li class="login"><a class="login" href="<c:url value="/register/step1" />"><b>회원 가입하기</b></a></li>
			<li>&nbsp;&nbsp;&nbsp;&nbsp;</li>
			<li class="login"><a class="login" href="<c:url value="/login" />"><b>로그인</b></a></li>
			<li>&nbsp;&nbsp;&nbsp;&nbsp;</li>
		</ul>
	</c:if>
	<div class="menu" >
      <nav class="header">
        <ul class="header">
          <li></li>
          <li><a class="header" href="<c:url value="/main" />">Main</a></li>
          <li><a class="header" href="<c:url value="/classes/list"/>">Classes</a></li>
          <li><a class="header" href="<c:url value="/board/list" />">Board</a></li>
          <li><a class="header" href="<c:url value="/edit/info" />">Edit</a></li>
          <li><a class="header" href="<c:url value="/register/step0" />">Register</a></li>
          <li></li>
      	</ul>
      <a id="pull" href="#"></a>
    </nav>
    </div>
</body>
</html>