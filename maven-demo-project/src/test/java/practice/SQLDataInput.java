package practice;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class SQLDataInput {

	public static void main(String[] args) throws Throwable  {
		Driver DriverRef=new Driver();
		DriverManager.registerDriver(DriverRef);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Qspiders","root","root");
		Statement stat = conn.createStatement();
		String selectQuery = "select * from Students";
		ResultSet result = stat.executeQuery(selectQuery);
		
		while(result.next()) {
			System.out.println(result.getInt(1)+"\t"+result.getString(2));
			System.out.println(result.getString("id")+"\t"+result.getString("Name")+"\t"+result.getString("Address"));
			System.out.println(result.getString("Address"));
			
			
		}
		conn.close();

	}

}
