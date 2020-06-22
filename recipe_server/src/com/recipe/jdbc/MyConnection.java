package com.recipe.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyConnection {
	public static Connection getConnection() throws ClassNotFoundException,SQLException{
		String className = "oracle.jdbc.driver.OracleDriver";
		Connection con = null;
		
		Class.forName(className);
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "recipe";
		String password = "recipe";
		con = DriverManager.getConnection(url, user, password);
		System.out.println("DB와 연결성공!");
		
		return con;
	}

	public static void close(Connection con) {
		try {
			if(con != null) {
				con.close();
				System.out.println("DB연결 해제");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement stmt, Connection con) {
		try {
			if(stmt != null) {
				stmt.close();
			}
			close(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rs, Statement stmt, Connection con) {
		try {
			if(rs != null) {
				rs.close();
			}
			close(stmt, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
