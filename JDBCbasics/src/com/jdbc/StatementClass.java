package com.jdbc;
import java.sql.*;
public class StatementClass {

	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //Registering a JDBC Driver
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr"); //Opening a connection
			
			//Executing a Query
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select employee_id,first_name,last_name from employees"); //The Query result is stored in a ResultSet
			
			//Data is extracted from the ResultSet
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
			
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
