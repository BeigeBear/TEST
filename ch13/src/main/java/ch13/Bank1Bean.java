package ch13;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Bank1Bean {

	private int aid;
	private String aname;
	private int balance;
	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	
	public void connect() {
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
			conn = dataSource.getConnection();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void disconnect() {
		try {
			if(conn != null) {
				conn.close();
			}
		}
		catch (SQLException e) {
			System.out.println(e);
		}
		System.out.println("close");
	}
	
	
	public void getData() {
		connect();
		
		try {
			stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM bank1");
			resultSet.next();
			aid = resultSet.getInt("aid");
			aname = resultSet.getString("aname");
			aid = resultSet.getInt("balance");
		}
		catch (Exception e) {
			System.out.println(aid + aname + balance);
			System.out.println(e);
		}
		finally {
			disconnect();
		}
	}
	
	
	public Boolean transfer(int bal) {
		connect();
		
		try {
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement("UPDATE bank1 SET balance = balance-? WHERE aid=101");
			pstmt.setInt(1, bal);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("UPDATE bank2 SET balance = balance+? WHERE aid=201");
			
			pstmt.setInt(1, bal);
			pstmt.executeUpdate();
			stmt = conn.createStatement();
			
			ResultSet resultSet = stmt.executeQuery("SELECT balance FROM bank2 WHERE aid=201");
			
			resultSet.next();
			
			if(resultSet.getInt(1) > 40) {
				conn.rollback();
				return false;
			}
			else {
				conn.commit();
			}
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			disconnect();
		}
		return true;
		
		
		
	}


	public int getAid() {
		return aid;
	}


	public String getAname() {
		return aname;
	}


	public int getBalance() {
		return balance;
	}
	
}
