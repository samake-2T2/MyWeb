package com.myweb.util;

public class PageVO {
	
	//화면에 그려질 페이지네이션을 계산하는 변수 선언
	private int startPage; //게시판 화면에 보여질 첫페이지 번호
	private int endPage; //게시판 화면에 보여질 끝페이지 번호
	private boolean prev, next; //다음 이전 활성화 여부
	
	private int pageNum; //현재 조회하는 페이지 번호
	private int amount = 10; //한 페이지에서 몇개의 데이터를 보여줄건가
	private int total; //총 게시물 수
	
	
	public PageVO(int pageNum ,int total, int amount) {
		
		this.total = total; //전체게시글 수
		this.pageNum = pageNum; //현재 조회하는 페이지 번호
		this.amount = amount; //한 페이지에서 몇개의 데이터를 보여줄건가
		
		// 1. endPager계산
		// 현재조회하는 번호가 1~10 -> 10
		// 현재조회하는 번호가 11~20 -> 20
		// 공식: (int)Math.ceil(페이지번호 / 화면에 보여질 페이지네이션 개수) * 화면에 보여질 페이지네이션 개수
		this.endPage = (int)(Math.ceil(this.pageNum / (double)10)  ) * 10;
		
		// 2. startPager계산
		// 공식: 끝페이지 번호 - 화면에보여질 페이지네이션개수 + 1;
		this.startPage = this.endPage - 10 + 1;
		
		// 3. 실제끝번호 realEnd
		// 만약 게시글이 52개라면? -> 실제끝번호 6
		// 만약 게시글이 163개라면? -> 실제끝번호 17
		// 공식: (int)Math.ceil( 전체게시글수 / amount개수 )
		int realEnd = (int)Math.ceil(total / (double)this.amount );
		
		
		// 4. endPage의 결정
		// 예시: 131개 게시물
		// 1번 페이지 클릭시 -> endPage = 10, realEnd = 14
		// 11번 페이지 클릭시 -> endPage = 14, realEnd = 14
		if(this.endPage > realEnd ) {
			this.endPage = realEnd;
		}
		
		// 5. prev버튼 활성화 여부(11, 21~~~~부터 true)
		// startPage = 1, 11, 21, 31.........
		this.prev = this.startPage > 1;
		
		
		// 6. next버튼 활성화 여부
		// 예시: 131개 게시물
		// 1~10번까지 endPage = 10, realEnd = 14(true)
		// 11~20번까지 endPage = 14, realEnd = 14(false)
		this.next = realEnd > this.endPage;
	}


	@Override
	public String toString() {
		return "PageVO [startPage=" + startPage + ", endPage=" + endPage + ", prev=" + prev + ", next=" + next
				+ ", pageNum=" + pageNum + ", amount=" + amount + ", total=" + total + "]";
	}


	public int getStartPage() {
		return startPage;
	}


	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}


	public int getEndPage() {
		return endPage;
	}


	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}


	public boolean isPrev() {
		return prev;
	}


	public void setPrev(boolean prev) {
		this.prev = prev;
	}


	public boolean isNext() {
		return next;
	}


	public void setNext(boolean next) {
		this.next = next;
	}


	public int getPageNum() {
		return pageNum;
	}


	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}
	
	
}
