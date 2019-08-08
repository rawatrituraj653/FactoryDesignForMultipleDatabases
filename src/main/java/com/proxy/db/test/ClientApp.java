package com.proxy.db.test;

import java.sql.Connection;
import java.util.Scanner;

import com.proxy.db.data.StudentData;
import com.proxy.db.factory.DataBaseFactory;

public class ClientApp {

	public static void main(String[] args) {
		
		System.out.println("App For Student Data");
		try(Scanner scan=new Scanner(System.in)){
			System.out.println("Choose Database Type");
			System.out.println("1.ORACLE DB");
			System.out.println("2.MYSQL DB");
			Integer db=scan.nextInt();
			if(db<=3) {
			Connection conn=DataBaseFactory.getDbObject(db);
			if(conn!=null) {
				StudentData data=new StudentData();
				data.getStudentData(conn);
			}else {
				System.out.println("This Connection Not Found");	
				}
			}
			else {
				System.out.println("This is wrong Choice");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
}
