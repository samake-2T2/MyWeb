package com.myweb.util.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myweb.user.model.UsersVO;

// 글 수정, 삭제에 대한 필터
@WebFilter({"/board/modify.board", "/board/update.board", "/board/delete.board"})
public class BoardFilter02 implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		request.setCharacterEncoding("UTF-8");
		
		/*
		 * 1. 등록화면에서 작성자를 id값으로 고정.
		 * 2. 각각 요청에서 writer값이 반드시 담겨 넘어오도록 처리.
		 * 3. 세션의 id와 writer의 비교.
		 */
		
		HttpSession session = req.getSession();
		UsersVO vo = (UsersVO)session.getAttribute("user_vo"); // 회원측에서 만든 userVO
		
		
		if(vo == null) { // 로그인이 만료된 회원
			//res.sendRedirect("/MyWeb/user/login.jsp");
			
			res.setContentType("text/html"); // 문서의 형식지정
			res.setCharacterEncoding("UTF-8");
			
			PrintWriter out = res.getWriter(); // 출력의 방향-> 브라우저
			out.println("<script>");
			out.println("alert('로그인이 필요한 서비스입니다.')");
			out.println("location.href='/MyWeb/user/login.jsp'");
			out.println("</script>");
			return; // 컨트롤러를 실행하지 않는다.
		}
		
		String user_id = vo.getId();
		String writer = req.getParameter("writer"); // 작성자
		System.out.println(writer);
		
		if(!user_id.equals(writer) || writer == null) {
			res.setContentType("text/html"); // 문서의 형식지정
			res.setCharacterEncoding("UTF-8");
			
			PrintWriter out = res.getWriter(); // 출력의 방향-> 브라우저
			out.println("<script>");
			out.println("alert('해당 글의 작성자가 아닙니다.')");
			out.println("location.href='/MyWeb/board/list.board'");
			out.println("</script>");
			
			return; // 컨트롤러를 실행하지 않는다.
		}
		
		chain.doFilter(request, response); // 서블릿이나 or 연결되어 있는 다른 필터를 실행시킴
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
