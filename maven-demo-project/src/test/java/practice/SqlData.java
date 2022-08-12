package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class SqlData {

	public static void main(String[] args) throws Exception {
		// step 1: Register or load the MySql database
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		// step 2: Get connect to database
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/teachers_info","root","root");
		
		//Step 3: create sql statement/query
		Statement stat=conn.createStatement();
		String selectQuery = "select * from teachers";
		
		//Step 4 execute statement query
		ResultSet result = stat.executeQuery(selectQuery);
		
		while(result.next()) {


			
		}
		//step 5: close the database connection
		conn.close();

	}

}
