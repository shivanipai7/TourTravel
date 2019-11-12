package com.training.utils;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
public class DbConnection {

	public static Connection getOracleConnection() {
		Connection con = null;
		try {
			
			 Properties props = new Properties();
		        try
		        {
		            props.load(DbConnection.class.getClassLoader().getResourceAsStream("Dbconnection.properties"));

		        }
		        catch (IOException ex)
		        {
		            ex.printStackTrace();
		        }
		        
			
			Class.forName(props.getProperty("db.oracle.driverClass"));
			con = DriverManager.getConnection(props.getProperty("db.oracle.url"), 
					props.getProperty("db.oracle.userName"), 
					props.getProperty("db.oracle.passWord"));
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return con;
	}
}
