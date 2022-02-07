package com.myweb.user.model;

import java.sql.Timestamp;

public class UsersVO {
	/*
	 * 1. DB관련 컬럼을 변수로 은닉된 선언
	 * 2. getter, setter메서드를 선언
	 * 3. 생성자는 기본생성자와, 모든 멤버변수를 초기화하는 생성자를 만듭니다.
	 */
	
	private String id;
	private String pw;
	private String name;
	private String email;
	private String address;
	private Timestamp regdate;
	
	public UsersVO() {
		// TODO Auto-generated constructor stub
	}

	public UsersVO(String id, String pw, String name, String email, String address, Timestamp regdate) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.address = address;
		this.regdate = regdate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	
	
}
