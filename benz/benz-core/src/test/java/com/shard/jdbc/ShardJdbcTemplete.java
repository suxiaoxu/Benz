package com.shard.jdbc;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.support.JdbcAccessor;

public class ShardJdbcTemplete extends JdbcTemplate{
	
	private Map<String,DataSource> dataSourceMaps;
	
	private Map<String,ShardInfoRule> shardInfoRuleMaps;
	
	private DataSource dataSourceDefault;
	
	private static ThreadLocal<String> dataSourceKeyValue = new ThreadLocal<String>() {
		public String initialValue() {
			return null;
		}
	};
	
	public int update(String sql,ShardInfoValue<?> shardInfoValue, Object... args){
		sql = control(sql,shardInfoValue);
		return this.update(sql, newArgPreparedStatementSetter(args));
	}
	
	public void query(String sql,ShardInfoValue<?> shardInfoValue, Object[] args, RowCallbackHandler rch) throws DataAccessException {
		sql = control(sql,shardInfoValue);
		query(sql, newArgPreparedStatementSetter(args), rch);
	}
	
	@Override
	public DataSource getDataSource(){
		String dataSourceKey = dataSourceKeyValue.get();
		if(dataSourceKey == null){
			return dataSourceDefault;
		}
		return dataSourceMaps.get(dataSourceKey);
	}
	
	private String control(String sql,ShardInfoValue<?> shardInfoValue){
		ShardInfoRule shardInfoRule = shardInfoRuleMaps.get(shardInfoValue.getTableName());
		String dataBaseName = shardInfoRule.obtainDataBaseName(shardInfoValue);
		String tableName = shardInfoRule.obtainTableName(shardInfoValue);
		sql = sql.replace(shardInfoValue.getTableName(), tableName);
		dataSourceKeyValue.set(dataBaseName);
		return sql;
	}

	public void setDataSourceMaps(Map<String, DataSource> dataSourceMaps) {
		this.dataSourceMaps = dataSourceMaps;
	}

	public void setShardInfoRuleMaps(Map<String, ShardInfoRule> shardInfoRuleMaps) {
		this.shardInfoRuleMaps = shardInfoRuleMaps;
	}

	public void setDataSourceDefault(DataSource dataSourceDefault) {
		this.dataSourceDefault = dataSourceDefault;
	}
	
	

}
