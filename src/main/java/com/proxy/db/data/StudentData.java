package com.proxy.db.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class StudentData {

	public void getStudentData(Connection conn) throws Exception{
		PreparedStatement psmt= conn.prepareStatement("select * from student");
		ResultSet rs= psmt.executeQuery();
		System.out.println("SID\tSNAME\tSGEN\tSFEE\tSPASSWORD");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)
			+"\t"+rs.getDouble(4)+"\t"+rs.getString(5));
		}
	}
}
