<%@page import="com.myweb.user.model.UsersVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<%
	UsersVO vo = (UsersVO)session.getAttribute("user_vo");
%>

<section>
	<div align="center">
		<h3>회원정보수정</h3>
		<hr/>
		
		<form action="update_ok.jsp" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id" value="<%= vo.getId() %>" readonly><!-- 태그는 사용하되, 읽기만 가능 --></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pw" placeholder="4글자이상"  required pattern="\\w{4, }"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="<%= vo.getName() %>" required></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="email" name="email" value="<%= vo.getEmail() %>"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="address" value="<%= vo.getAddress() %>"></td>
				</tr>
			</table>
			<br>
			<input type="submit" value="정보수정" class="btn btn-default">
			<input type="button" value="마이페이지" class="btn btn-primary" onclick="location.href='login.jsp'">
		</form>
	</div>
</section>

<%@ include file="../include/footer.jsp" %>