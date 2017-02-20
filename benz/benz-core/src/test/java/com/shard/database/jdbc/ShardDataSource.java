package com.shard.database.jdbc;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Map;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class ShardDataSource implements DataSource{

	private Map<String,DataSource> dataSourceMaps; 
	
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Connection getConnection() throws SQLException {
		ShardContext shardContext = ShardContextThreadLocal.dataSourceKeyValue.get();
		if(shardContext == null){
			return null;
		}
		DataSource dataSource = dataSourceMaps.get(shardContext.getDataSourceId());
		ShardConnection shardConection = new ShardConnection();
		shardConection.setConnection(dataSource.getConnection());		
		return shardConection;
	}

	@Override
	public Connection getConnection(String username, String password)
			throws SQLException {
		ShardContext shardContext = ShardContextThreadLocal.dataSourceKeyValue.get();
		if(shardContext == null){
			return null;
		}
		DataSource dataSource = dataSourceMaps.get(shardContext.getDataSourceId());
		ShardConnection shardConection = new ShardConnection();
		shardConection.setConnection(dataSource.getConnection(username,password));		
		return shardConection;
	}

	public Map<String, DataSource> getDataSourceMaps() {
		return dataSourceMaps;
	}

	public void setDataSourceMaps(Map<String, DataSource> dataSourceMaps) {
		this.dataSourceMaps = dataSourceMaps;
	}
	
	
	
}
