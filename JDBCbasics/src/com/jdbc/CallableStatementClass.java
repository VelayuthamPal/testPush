package com.jdbc;
import java.sql.*;

public class CallableStatementClass {

	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			
			CallableStatement cs=con.prepareCall("{call addNum(?,?,?)}");
			cs.registerOutParameter(3, Types.INTEGER);
			cs.setInt(1, 10);
			cs.setInt(2, 20);
			cs.execute();
			
			System.out.println("The Result of the Addition is: "+cs.getInt(3));
			cs.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
