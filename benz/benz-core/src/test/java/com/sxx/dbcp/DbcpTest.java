package com.sxx.dbcp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

public class DbcpTest {

	@Test
	public void query() throws SQLException{
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/shard2");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		dataSource.setInitialSize(5);
		dataSource.setMaxActive(10);
		
		Connection con = dataSource.getConnection();
		Statement statement = con.createStatement();
		ResultSet result = statement.executeQuery("select * from shard_table02");
		printRs(result);
		System.out.println("result"+result.getFetchSize());
		
	}
	
	public static void printRs(ResultSet rs) throws SQLException {
		// Ensure we start with first row
		rs.beforeFirst();
		while (rs.next()) {
			// Retrieve by column name
			String first = rs.getString("user_name");
			int  last = rs.getInt("user_id");
			System.out.print(", First: " + first);
			System.out.println(", Last: " + last);
		}
		System.out.println();
	}

}
