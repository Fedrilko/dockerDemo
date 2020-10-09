package com.fredor.products.DockerMySQLServerDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {
	private Connection conneciton;
	
	public UserDao() throws SQLException {
		conneciton = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_db", 
				"root", "root");
	}
	
	public void printAllUsers() throws SQLException {
		try(Statement st = conneciton.createStatement()){
			ResultSet rs = st.executeQuery("select * from users");
			StringBuilder sb = new StringBuilder();
			while(rs.next()) {
				sb.append(rs.getString("name") + "\n");
			}
			System.out.println(sb);
		}
	}
}
