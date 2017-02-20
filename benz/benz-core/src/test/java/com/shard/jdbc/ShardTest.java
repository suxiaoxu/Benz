package com.shard.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:jdbcAnnoctionContext.xml" })
public class ShardTest {
	
	@Autowired
	private ShardJdbcTemplete shardJdbcTemplete;
	
	//@Test
	public void shardJdbcTemplete(){
		String sql = "INSERT INTO shard_table(user_id,user_name) "
				+ "VALUES(?,?)";
		for(int i = 1000 ; i< 1004 ; i++ ){
			Object[] args = { i, "lisi"+i };
			shardJdbcTemplete.update(sql, getShardInfoValue(i), args);
		}
	}
	
	@Test
	public void shardJdbcQuery(){
		int i = 1002;
		String sql = " SELECT user_id,user_name"
				+ " FROM shard_table WHERE user_id = ?";
		Object[] args = new Object[] { i };
		shardJdbcTemplete.query(sql, getShardInfoValue(i), args, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				System.out.println("user_id="+rs.getInt("user_id") +" user_name="+rs.getString("user_name"));
				
			}
		});
	}
	
	//@Test
	public void deleteJdbcTemplete(){
		String sql = "DELETE FROM shard_table WHERE user_id= "
				+ "?";
		for(int i = 1021 ; i< 4000 ; i++ ){
			Object[] args = { i};
			shardJdbcTemplete.update(sql, getShardInfoValue(i), args);
		}
	}
	
	@Test
	public void shardJdbcQueryThread(){
		new Thread() {  
            public void run() {  
            	String sql = "INSERT INTO shard_table(user_id,user_name) "
        				+ "VALUES(?,?)";
                for(int i = 1020 ; i< 2000 ;i++){
                	Object[] args = { i, "lisi"+i };
        			shardJdbcTemplete.update(sql, getShardInfoValue(i), args);
                }
            };  
        }.start();
      Thread thread =  new Thread() {  
            public void run() {  
            	String sql = "INSERT INTO shard_table(user_id,user_name) "
        				+ "VALUES(?,?)";
            	for(int i = 2000 ; i< 2800 ;i++){
            		Object[] args = { i, "lisi"+i };
        			shardJdbcTemplete.update(sql, getShardInfoValue(i), args);
                }
            };  
        }; 
        thread.start();
        try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ShardInfoValue<Long> getShardInfoValue(long value){
		ShardInfoValue<Long> shardInfoValue = new ShardInfoValue<Long>();
		shardInfoValue.setColumnName("id");
		shardInfoValue.setColumnValue(value);
		shardInfoValue.setTableName("shard_table");
		return shardInfoValue;
	}

}
