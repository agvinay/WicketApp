package com.gcn.utilities;

import javax.sql.*;

import java.io.Serializable;
import java.sql.*;

public class DemurrageDBManager {
	
	String dbtime;
	String dbUrl = "jdbc:mysql://127.0.0.1:3306/wasaes";
	String dbClass = "com.mysql.jdbc.Driver";
	Connection con ;
		
	public  Connection getDbConnection()
	{
	
	try {

		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection (dbUrl,"root","");
		System.out.println("done");
		
		
		
		} //end try

		catch(ClassNotFoundException cnfe) {
		cnfe.printStackTrace();
			System.out.println("here0");
		}

		catch(SQLException se) {
		se.printStackTrace();
		//	System.out.println("here");
		}
	
	return con;
	}
	
	public void closeDbConnection()
	{
		try {
			con.close();
			
		    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
