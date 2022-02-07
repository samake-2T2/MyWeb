<%@page import="com.myweb.user.model.UsersVO"%>
<%@page import="com.myweb.user.model.UsersDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String address = request.getParameter("address");
	
	// DAO에 update()메서드를 생성하고 , 업데이트 구문을 수행
	// 성공실패 여부를 1,0으로 반환
	// 수정성공시 script태그 이용 "회원정보가 수정되었습니다." 출력후에 마이페이지로 이동
	// 수정실패시 "회원정보 수정에 실패했습니다." 출력 후 마이페이지로 이동
	UsersDAO dao = UsersDAO.getInstance();
	UsersVO vo = new UsersVO(id, pw, name, email, address, null);
	
	int result = dao.update(vo);
	if(result == 1) {
		session.setAttribute("user_vo", vo); // 성공시에 세션정보 수정
%>
	<script>
		alert("회원정보가 수정되었습니다.");
		location.href="mypage.jsp";
	</script>
<% } else {%>
	<script>
		alert("회원정보 수정에 실패했습니다.");
		location.href="mypage.jsp";
	</script>
<% } %>