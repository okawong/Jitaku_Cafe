package com.okawong.restaurant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySqlAccess {
	private Connection connection = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public void readDataBase() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connectionUrl = "jdbc:mysql://localhost:	?autoReconnect=true&useSSL=false";
			connection = DriverManager.getConnection(connectionUrl, "root", "admin");
			statement = connection.createStatement();
			resultSet = statement.executeQuery("USE customers ;");
			resultSet = statement.executeQuery("select * from myCustomers where FirstName = 'JiIn';");

			while (resultSet.next()) {
				System.out.println("Name:" + resultSet.getString("FirstName"));
			}

			System.out.println("running");
		} catch (Exception ex) {
			System.out.println("error");
			throw ex;
		} finally {
			connection.close();
		}
	}

}
