package com.proxy.db.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseFactory {
	
	private static Connection conn; 
	public static Connection getDbObject(int ch) throws Exception {
		String cls=choice(ch);
		Class.forName(cls);
		if(ch==1) {
		conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");		
		return conn;
		}	
		else if(ch==2) {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/springdb","root","root");
		return conn;
		}	
		return conn;
	}
	private static String choice(int ch) {
		String driver=null;
		switch (ch) {
		case 1:driver="oracle.jdbc.driver.OracleDriver";
			break;
		case 2: driver="com.mysql.jdbc.Driver";	break;	
		default:
			break;
		}	
		return driver;
	}	
}
