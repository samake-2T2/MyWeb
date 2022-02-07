<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- if else~ -->
	<c:choose>
		<c:when test="${ param.name eq '홍길동' }">홍길동입니다.</c:when>
		<c:when test="${ param.name eq '이순신' }">이순신입니다.</c:when>
		<c:otherwise>둘다 아닙니다.</c:otherwise>
	</c:choose>
	
	<!-- 20살이상이면 성인, 아니면 미성년자로 구분 -->
	<c:choose>
		<c:when test="${ param.age >= 20 }">성인 입니다.</c:when>
		<c:otherwise>미성년자 입니다.</c:otherwise>
	</c:choose>
</body>
</html>