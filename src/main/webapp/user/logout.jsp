<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<%
	//세션삭제
	session.invalidate();
	response.sendRedirect(request.getContextPath() + "/index.jsp"); // 반드시 절대경로로 넣을것
%>
<%@ include file="../include/footer.jsp" %>