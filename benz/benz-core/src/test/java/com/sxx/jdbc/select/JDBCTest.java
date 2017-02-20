package com.sxx.jdbc.select;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class JDBCTest {

	private static Connection conn = null;
	static{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.1:1521:SXT", "scott", "tiger");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//最基本的操作读取
	public void testStmt(){
		  ResultSet rs = null;  
		  Statement stmt = null;  
		  try {
			 stmt = conn.createStatement();  
			 rs = stmt.executeQuery("select * from dept");  
			 while(rs.next()) {  
			      System.out.println(rs.getString("deptno"));  
			      System.out.println(rs.getInt("deptno"));  
			 }  
			 rs.close();  
			 stmt.close();  
			 conn.close(); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	//PreparedStatement读取 
	public void testPrepStmt(){
		PreparedStatement pstmt = null;  
		try {
			pstmt = conn.prepareStatement("insert into dept2 values (?, ?, ?)");  
			pstmt.setInt(1, 33);  
			pstmt.setString(2, "name");  
			pstmt.setString(3, "loc");  
			pstmt.executeUpdate();  
			pstmt.close();  
			conn.close();  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	//调用存储过程 
	public void testProc(){
		CallableStatement cstmt;
		try {
			cstmt = conn.prepareCall("{call p(?, ?, ?, ?)}");
			cstmt.registerOutParameter(3, Types.INTEGER);  
			cstmt.registerOutParameter(4, Types.INTEGER);  
			cstmt.setInt(1, 3);  
			cstmt.setInt(2, 4);  
			cstmt.setInt(4, 5);  
			cstmt.execute();  
			System.out.println(cstmt.getInt(3));  
			System.out.println(cstmt.getInt(4));  
			cstmt.close();  
			conn.close();  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	//执行批处理
	public void testBatch(){
		 /* 
		9.	        Statement stmt = conn.createStatement(); 
		10.	        stmt.addBatch("insert into dept2 values (51, '500', 'haha')"); 
		11.	        stmt.addBatch("insert into dept2 values (52, '500', 'haha')"); 
		12.	        stmt.addBatch("insert into dept2 values (53, '500', 'haha')"); 
		13.	        stmt.executeBatch(); 
		14.	        stmt.close(); 
		15.	        */  
		
		  
		 try {
			PreparedStatement ps = conn.prepareStatement("insert into dept2 values (?, ?, ?)"); 
			ps.setInt(1, 61);
			 ps.setString(2, "haha");  
			 ps.setString(3, "bj");  
			 ps.addBatch();  
			   
			 ps.setInt(1, 62);  
			 ps.setString(2, "haha");  
			 ps.setString(3, "bj");  
			 ps.addBatch();  
			   
			 ps.setInt(1, 63);  
			 ps.setString(2, "haha");  
			 ps.setString(3, "bj");  
			 ps.addBatch();  
			   
			 ps.executeBatch();  
			 ps.close();  
			   
			 conn.close();  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	//将整批分批执行批处理
	//这才是理想的解决方案，它避免了SQL注入和内存不足的问题。看看我们如何递增计数器计数，一旦BATCHSIZE 达到 1000，我们调用executeBatch
	public void testBatchs() throws SQLException{
		String sql = "insert into employee (name, city, phone) values (?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		final int batchSize = 1000;
		int count = 0;
		/*for (Employee employee: employees) {
		    ps.setString(1, employee.getName());
		    ps.setString(2, employee.getCity());
		    ps.setString(3, employee.getPhone());
		    ps.addBatch();
		    if(++count % batchSize == 0) {
		        ps.executeBatch();
		    }
		}*/
		ps.executeBatch(); // insert remaining records
		ps.close();
		conn.close();

	}
	//执行事务
	public void testTransaction(){ 
		 Statement stmt = null;
		 try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();  
			stmt.addBatch("insert into dept2 values (51, '500', 'haha')");  
			stmt.addBatch("insert into dept2 values (52, '500', 'haha')");  
			stmt.addBatch("insert into dept2 values (53, '500', 'haha')");  
			stmt.executeBatch();  
			conn.commit();  
		} catch (SQLException e) {
			try {
				conn.rollback();
				conn.setAutoCommit(true); 
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  
			e.printStackTrace();
		}finally{
			try {  
			   if(stmt != null)  
			       stmt.close();  
			   if(conn != null)  
			       conn.close();  
			 } catch (SQLException e) {  
			     e.printStackTrace();  
			 }  
		}
	}
	
}
