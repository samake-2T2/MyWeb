<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<%@ include file="../include/header.jsp"%>


<div class="container">
	<h3>My Web게시판</h3>

	<table class="table table-bordered">
		<thead>
			<tr>
				<th>글 번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>날짜</th>
				<th>조회수</th>
			</tr>
		</thead>

		<c:forEach var="vo" items="${list}">
			<tbody>
				<tr>
					<td>${vo.bno}</td>
					<td>${vo.writer}</td>
					<td><a href="content.board?bno=${vo.bno}">${vo.title}</a></td>
					<td><fmt:formatDate var="regdate" value="${vo.regdate }"
							pattern="yyyy년MM월dd일 HH시mm분" /> ${regdate}</td>
					<td>${vo.hit}</td>
				</tr>
			</tbody>
		</c:forEach>

		<tbody>
			<tr>
				<td colspan="5" align="right">
					<form action="" class="form-inline">
						<div class="form-group">
							<input type="text" name="search" placeholder="제목검색" class="form-control">
							<input type="submit" value="검색" class="btn btn-default">
							 
								<c:if test="${sessionScope.user_vo != null }">
								<input type="button" value="글 작성" class="btn btn-default" onclick="location.href='write.board'">								
								</c:if>
						</div>
					</form>
				</td>
			</tr>
		</tbody>
		<tbody>
			<tr>
				<td colspan="5" align="center">
					<ul class="pagination">
						<!-- 2. 이전버튼 활성화 여부 -->
						<c:if test="${pageVO.prev }">
							<li><a
								href="list.board?pageNum=${pageVO.startPage - 1 }&amount=${pageVO.amount}">prev</a></li>
						</c:if>

						<c:forEach var="num" begin="${pageVO.startPage}"
							end="${pageVO.endPage}">
							<li class="${pageVO.pageNum eq num ? 'active' : '' }"><a
								href="list.board?pageNum=${num}&amount=${pageVO.amount}">${num}</a>
							</li>
						</c:forEach>

						<!-- 3. 다음버튼 활성화 여부 -->
						<c:if test="${pageVO.next }">
							<li><a
								href="list.board?pageNum=${pageVO.endPage + 1 }&amount=${pageVO.amount}">next</a></li>
						</c:if>
					</ul>
				</td>

			</tr>
		</tbody>

	</table>
</div>

${pageVO}

<%@ include file="../include/footer.jsp"%>





