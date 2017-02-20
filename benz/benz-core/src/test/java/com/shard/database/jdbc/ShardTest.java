package com.shard.database.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:jdbcShardContext.xml" })
public class ShardTest implements ShardInfoRule<Integer>{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private String databaseName = "shard";
	private String tableName = "shard_table0";
	
	//@Test
	public void query(){
		int i = 1002;
		String sql = " SELECT user_id,user_name"
				+ " FROM shard_table WHERE user_id = ?";
		ShardContextThreadLocal.setShardRuleContext(getShardeRule(i));
		Object[] args = new Object[] { i };
		jdbcTemplate.query(sql, args, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				System.out.println("user_id="+rs.getInt("user_id") +" user_name="+rs.getString("user_name"));
				
			}
		});
	}
	
	//@Test
	public void insert(){
		String sql = "INSERT INTO shard_table(user_id,user_name) "
				+ "VALUES(?,?)";
		for(int i = 2000 ; i< 2004 ; i++ ){
			ShardContextThreadLocal.setShardRuleContext(getShardeRule(i));
			Object[] args = { i, "lisi"+i };
			jdbcTemplate.update(sql, args);
		}
	}
	
	@Test
	public void deleteJdbcTemplete(){
		String sql = "DELETE FROM shard_table WHERE user_id= "
				+ "?";
		for(int i = 1010 ; i<= 2100 ; i++ ){
			ShardContextThreadLocal.setShardRuleContext(getShardeRule(i));
			Object[] args = { i};
			System.out.println("before i = "+i);
			if(i==2760){
				System.out.println("1");
			}
			jdbcTemplate.update(sql,  args);
			System.out.println("after i = "+i);
		}
	}
	
	

	@Override
	public ShardContext getShardeRule(Integer t) {
		ShardContext shardContext = new ShardContext();
		long dataBaseNum = (t % 2) + 1;
		String dataBaseName = databaseName + dataBaseNum;
		shardContext.setDataSourceId(dataBaseName);
		long tableNum = (t % 4) +1;
		String tableNameT = tableName + tableNum;
		shardContext.setReplaceTable(tableNameT);
		shardContext.setOriginTable("shard_table");
		return shardContext;
	}

}
