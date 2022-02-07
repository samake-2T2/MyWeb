package com.myweb.user.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.myweb.util.JdbcUtil;

public class UsersDAO {

	//1. 싱글톤패턴을 이용한 클래스
	//스스로 객체를 생성하고 1개로 제한
	private static UsersDAO dao = new UsersDAO();
	
	//2. 생성자에 private를 붙입니다
	private UsersDAO() {
		
		try {
			// Class.forName("oracle.jdbc.driver.OracleDriver");
			// 커넥션풀 정보
			InitialContext ctx =new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//3. 외부에서 객체생성을 요구할때 멤버변수 dao를 반환합니다.
	public static UsersDAO getInstance() {
		return dao;
	}
	
	////////////////////////////////////////////////////////
	//데이터베이스 연결주소
	String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	String uid = "jsp";
	String upw = "jsp";
	
	DataSource ds; //연결정보(풀정보) 저장
	
	
	//아이디 중복검사메서드
	public int idCheck(String id) {
		
		int result = 0;
		
		String sql = "select * from users where id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//conn = DriverManager.getConnection(url, uid, upw);
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //true
				result = 1; //아이디가 있는경우
			} else { //false
				result = 0; //아이디중복이 없는경우
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return result;
	}
	
	//회원가입
	public int insert(UsersVO vo) {
		int result = 0;
		
		String sql = "insert into users (id,pw, name, email, address) values (?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId() );
			pstmt.setString(2, vo.getPw() );
			pstmt.setString(3, vo.getName() );
			pstmt.setString(4, vo.getEmail() );
			pstmt.setString(5, vo.getAddress() );
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		} 
		
		return result;
	}
	
	public UsersVO login(String id, String pw) {
		UsersVO vo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from users where id = ? and pw = ?";
		
		try {
			// conn 생성
			conn = DriverManager.getConnection(url, uid, upw);
			// pstmt 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			// sql실행
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // 로그인 성공
				vo = new UsersVO();
				
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setAddress(rs.getString("address"));
				vo.setRegdate(rs.getTimestamp("regdate"));
			} else {
				vo = null;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return vo;
	}
	
	public int update(UsersVO vo) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE USERS SET PW = ?, NAME = ?, EMAIL = ?, ADDRESS = ? WHERE ID = ?";
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getAddress());
			pstmt.setString(5, vo.getId());
			
			result = pstmt.executeUpdate(); // 성공시 1반환, 실패시 0반환
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}
		
		return result;
	}
	
	public int delete(UsersVO vo) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM USERS WHERE ID = ?";
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			
			result = pstmt.executeUpdate(); // 성공시 1반환, 실패시 0반환
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}
		return result;
	}
}
