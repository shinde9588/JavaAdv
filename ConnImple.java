package com.form;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnImple {

	static Connection con = null;
	
	public static Connection getconnection() {
		
		try {
			Class.forName(JdbcConnection.JDBC_NAME);
			con = DriverManager.getConnection(JdbcConnection.JDBC_URL,JdbcConnection.JDBC_USERNAME,JdbcConnection.JDBC_PASSWORD);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
