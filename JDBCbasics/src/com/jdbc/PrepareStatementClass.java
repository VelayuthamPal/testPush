package com.jdbc;
import java.sql.*;

public class PrepareStatementClass {

	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			
			PreparedStatement ps=con.prepareStatement("update employees set salary=? where  employee_id=? ");
			PreparedStatement ps1=con.prepareStatement("INSERT INTO sal VALUES (?,?)");
			ps.setInt(1, 2340);
			ps.setInt(2, 150);
			ps1.setInt(1, 2340);
			ps1.setInt(2, 150);
			ps.execute();
			ps1.execute();
			
			ps.close();
			con.close();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		

	}

}
