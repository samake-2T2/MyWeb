<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>formatNumber, parseNumber, formatDate, parseDate</h3>
	<!--  
		format: 출력할 형식변경
		parse: 형(타입)변환
	 -->
	 <h3>formatNumber</h3>
	 <c:set var="d01" value="2020" />
	 <fmt:formatNumber var="v01" value="${d01}" pattern="000000" />
	 <fmt:formatNumber var="v02" value="${d01}" pattern="0000.00" />
	 
	 d01값: ${d01}<br>
	 v01값: ${v01}<br>
	 v02값: ${v02}<br>
	 
	 <hr>
	 
	 <h3>formatDate -> 날짜의 형식변환(반드시 날짜형식을 가지고 있어야합니다.)</h3>
	 <c:set var="d02" value="<%= new Date() %>" />
	 <fmt:formatDate var="v03" value="${d02}" pattern="yyyyMMdd"/>
	 <fmt:formatDate var="v04" value="${d02}" pattern="yyyy년MM월dd일"/>
	 <fmt:formatDate var="v05" value="${d02}" pattern="yyyy-MM-dd HH:mm:ss"/>
	 
	 v03값: ${v03}<br>
	 v04값: ${v04}<br>
	 v05값: ${v05}<br>
	 
	 <hr>
	 
	 <h3>parseDate -> 문자를 날짜로 변환</h3>
	 <c:set var="d03" value="2020/01/26" />
	 <fmt:parseDate var="v06" value="${d03}" pattern="yyyy/MM/dd" />
	 
	 v06값: ${v06}<br>
	 
	 <c:set var="d04" value="2020/01/26 23:12:44" />
	 <fmt:parseDate var="v07" value="${d04}" pattern="yyyy/MM/dd HH:mm:ss" />
	 
	 v07값: ${v07}<br>
	 
	 <hr>
	 
	 <h3>parseNumber -> 문자를 숫자형으로 변환</h3>
	 <c:set var="d05" value="1.123"/>
	 <c:set var="d06" value="1.123abc"/>
	 
	 <fmt:parseNumber var="v08" value="${d05}" pattern="0.000" />
	 <fmt:parseNumber var="v09" value="${d06}" type="number" />
	 
	 v08값: ${v08}<br>
	 v09값: ${v09}<br>
	 
	 <hr>
	 
	 <h3>아래의 값을 2020년 05월 03일 형식으로 출력</h3>
	 <c:set var="time_a" value="2020-05-03"/>
	 <fmt:parseDate var="time_b" value="${time_a}" pattern="yyyy-MM-dd" />
	 <fmt:formatDate var="time_c" value="${time_b}" pattern="yyyy년 MM월 dd일"/>
	 
	결과값: ${time_c}
	 
</body>
</html>