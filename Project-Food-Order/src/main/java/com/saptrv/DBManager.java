package com.saptrv;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
static Connection cn;
public static java.sql.Connection getConnection()
{
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodorder", "root", "manager");
		
	}catch(Exception ee)
	{
		ee.printStackTrace();
	}
	return cn;
	
}
}
