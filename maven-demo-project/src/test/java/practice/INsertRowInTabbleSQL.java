package practice;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class INsertRowInTabbleSQL {

	public static void main(String[] args) throws Throwable {
		// Step 1: Register or load the MySql database
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		//Step 2: Get connection to data base
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/teachers_info","root","root");
		
		// Step3:create sql statement
		Statement stat = conn.createStatement();
		
		String query = "insert into teachers(first_name,last_name,address)values('Ratin','BN','India')";
		//step 4: Execute Query
		int result = stat.executeUpdate(query);
		if(result==1)
		{
			System.out.println("User created");
		}
		else
			System.out.println("User not created");
			
	}

}
