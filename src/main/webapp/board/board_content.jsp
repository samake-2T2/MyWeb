<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="../include/header.jsp"%>

<div align="center" class="div_center">

	<h3>게시글 내용 보기</h3>
	<hr>
	<table border="1" width="500">
		<tr>
			<td width="15%">글번호</td>
			<td width="30%">${vo.bno}</td>
			
			<td width="15%">조회수</td>
			<td width="40%">${vo.hit}</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${vo.writer}</td>
			
			<td>작성일</td>
			<td >
			<fmt:formatDate var="regdate" value="${vo.regdate }" pattern="yyyy년MM월dd일 HH시mm분"/>
			${regdate}							
			</td>
		</tr>
		
		<tr>
			<td width="15%">글제목</td>
			<td colspan="3">${vo.title}</td>
		</tr>
		<tr>
			<td width="15%">글내용</td>
			<td colspan="3" height="120px">${vo.content}</td>
		</tr>
		
		<tr>
			<td colspan="4" align="center">
				<input type="button" value="목록" onclick="location.href='list.board'">&nbsp;&nbsp;
				<c:if test="${sessionScope.user_vo.id eq vo.writer }">
				<input type="button" value="수정" onclick="location.href='modify.board?bno=${vo.bno}&writer=${vo.writer }'">&nbsp;&nbsp;
				<input type="button" value="삭제" onclick="location.href='delete.board?bno=${vo.bno}&writer=${vo.writer }'">&nbsp;&nbsp;
				</c:if>
			</td>
		</tr>
	</table>
	
	
	

	

</div>
<%@ include file="../include/footer.jsp" %>