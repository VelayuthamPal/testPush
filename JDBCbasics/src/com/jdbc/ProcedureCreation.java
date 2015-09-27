package com.jdbc;
import java.sql.*;

public class ProcedureCreation {

	public static String createProc()
	{
		String s="CREATE OR REPLACE PROCEDURE INSERT_PROC(id NUMBER(4),name VARCHAR(20)) AS "
				+ "BEGIN "
				+ "INSERT INTO EMP_MAST VALUES(id, name); "
				+ "END; ";
		
		return s;
	}
	public static String createTable()
	{
		String s="CREATE TABLE EMP_MAST "
				+ "(empId NUMBER(4),"
				+ "empName VARCHAR(20))";
		return s;
	}
	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			
			Statement s=con.createStatement();
			boolean r=s.execute(createTable());
					
			System.out.println("The Table is created T/F: "+r);		
			
			
			PreparedStatement ps=con.prepareStatement(createProc());
			
			System.out.println("Insertion is done T/F: ");
			
			CallableStatement cs=con.prepareCall("{call INSERT_PROC(?,?)}");
			cs.setInt(1, 1);
			cs.setString(2, "Anand");
			cs.execute();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
