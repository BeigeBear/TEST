package com.addrbook.model;

import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.sql.DataSource;

public class AddrDao {

	// 새 객체 생성 막기
	public AddrDao() {}
	
	// AddrDao 객체 상주
	private static AddrDao instance = new AddrDao();

	// AddrDao 객체 요청 (싱글턴)
	public static AddrDao getInstance() {
		return instance;
	}
	
	
	// DB 연결
	private Connection getConnection() {
		Context context = null;
		DataSource dataSource = null;
		Connection connection = null;
	
		try {
			context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:/comp/env/jdbc/Oracle11g");
			connection = dataSource.getConnection();
			System.out.println("연결 성공");
		}
		catch (Exception e) {
			System.out.println("연결 예외 발생");
			e.printStackTrace();
		}
		
		return connection;
	}
	
	
	// 주소록 전체 연락처 호출
	public ArrayList<AddrDto> getList() {
		ArrayList<AddrDto> addrList = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement
					("SELECT * FROM addrbook ORDER BY id ASC");
			resultSet = pstmt.executeQuery();
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				String comdept = resultSet.getString("comdept");
				String birth = resultSet.getString("birth");
				String tel = resultSet.getString("tel");
				String memo = resultSet.getString("memo");
				
				addrList.add(new AddrDto(id, name, email, comdept, birth, tel, memo));
			}
		}
		catch (SQLException e) {
			System.out.println("getList() 예외 발생");
			e.printStackTrace();
		}
		finally {
			try {
				resultSet.close();
				pstmt.close();
				connection.close();
			}
			catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return addrList;
	}
	
	
	// 주소록 개별 연락처 삽입
	public void insertAddr(AddrDto addr) {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement
					("INSERT INTO addrbook VALUES(addr_seq.nextval, ?, ?, ?, ?, ?, ?)");
			
			pstmt.setString(1, addr.getName());
			pstmt.setString(2, addr.getEmail());
			pstmt.setString(3, addr.getComdept());
			pstmt.setString(4, addr.getBirth());
			pstmt.setString(5, addr.getTel());
			pstmt.setString(6, addr.getMemo());
			
			pstmt.executeUpdate();
		}
		catch (SQLException e) {
			System.out.println("insertAddr() 예외 발생");
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
				connection.close();
			}
			catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	} // 클래스
	
	
	// 주소록 개별 연락처 호출
	public AddrDto readById(int id) {
		AddrDto addrDto = new AddrDto();
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement
					("SELECT * FROM addrbook WHERE id=?");
			pstmt.setInt(1, id);
			resultSet = pstmt.executeQuery();
			
			resultSet.next();
			
			String name = resultSet.getString("name");
			String email = resultSet.getString("email");
			String comdept = resultSet.getString("comdept");
			String birth = resultSet.getString("birth");
			String tel = resultSet.getString("tel");
			String memo = resultSet.getString("memo");
			
			addrDto = new AddrDto(id, name, email, comdept, birth, tel, memo);
		}
		catch (SQLException e) {
			System.out.println("readById() 예외 발생");
			e.printStackTrace();
		}
		finally {
			try {
				resultSet.close();
				pstmt.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return addrDto;
	}
	
	
	// 주소록 연락처 업데이트
	public void updateAddr(int id, AddrDto addrDto) {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement
					("UPDATE addrbook SET name=?, email=?, comdept=?, birth=?, tel=?, memo=? WHERE id ="+id);
			pstmt.setString(1, addrDto.getName());
			pstmt.setString(2, addrDto.getEmail());
			pstmt.setString(3, addrDto.getComdept());
			pstmt.setString(4, addrDto.getBirth());
			pstmt.setString(5, addrDto.getTel());
			pstmt.setString(6, addrDto.getMemo());
			
			pstmt.executeUpdate();
		}
		catch (SQLException e) {
			System.out.println("updateAddr() 예외 발생");
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	
	// 주소록 연락처 개별 삭제
	public void deleteAddr(int id) {

		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement
					("DELETE FROM addrbook WHERE id="+id);
			
			pstmt.executeUpdate();
		}
		catch (SQLException e) {
			System.out.println("deleteAddr() 예외 발생");
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
}