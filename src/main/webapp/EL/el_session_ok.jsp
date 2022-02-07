<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	${ vo }<br>
	${ auth }<br>
	<hr>
	${ vo.id }<br>
	${ vo.name }<br>
	<hr>
	${ sessionScope.vo.id }<br>
	${ sessionScope.vo.name }<br>
	${ sessionScope.auth }<br>
</body>
</html>