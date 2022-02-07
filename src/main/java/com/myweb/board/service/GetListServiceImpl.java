package com.myweb.board.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.model.BoardDAO;
import com.myweb.board.model.BoardVO;
import com.myweb.util.PageVO;

public class GetListServiceImpl implements BoardService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 받을 값 없음
		ArrayList<BoardVO> list = new ArrayList<>();
		
		// DAO생성
		BoardDAO dao = BoardDAO.getInstance();
		
		// 1. 첫페이지 진입시 초기값
		int pageNum = 1;
		int amount = 10;
		
		// 2. 화면에서 pageNum, amount값이 넘어오는 경우
		if(request.getParameter("pageNum") != null || request.getParameter("amount") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
			amount = Integer.parseInt(request.getParameter("amount"));
		}
		
		list = dao.getList(pageNum, amount); // 리스트 반환
		
		// 화면에서 값을 사용하기 위해 request에 저장
		request.setAttribute("list", list);
		
		//
		int total = dao.getTotal();
		PageVO pageVO = new PageVO(pageNum, total, amount);
		
		request.setAttribute("pageVO", pageVO);
	}
}
