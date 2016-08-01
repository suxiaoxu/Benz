package com.sxx.jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcSelectTest {
	public static String url = "jdbc:mysql://localhost:3306/sampledb";
	public static String user = "root";
	public static String password = "123456";
	public static void print() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection cnn1 = (Connection) DriverManager.getConnection(url, user, password);
		Connection cnn2 = (Connection) DriverManager.getConnection(url, user, password);
		Connection cnn3 = (Connection) DriverManager.getConnection(url, user, password);
		Connection cnn4 = (Connection) DriverManager.getConnection(url, user, password);
		Connection cnn5 = (Connection) DriverManager.getConnection(url, user, password);
		//创建SQL语句
		Statement st = cnn1.createStatement();
		//执行语句，返回结果
        ResultSet rt = st.executeQuery("show tables");
        //循环取出结果
        while(rt.next()) {
            //获取字段
            System.out.println(rt.getString(1));
        }
        //关闭资源，最先打开的最后关
        rt.close();
        st.close();
        cnn1.close();
        cnn2.close();
        cnn3.close();
        cnn4.close();
        cnn5.close();
	}
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		print();
	}
}
