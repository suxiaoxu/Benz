package com.shard.jdbc;


public class ShardInfo {

	private String dateBaseName;
	
	private String shardColumnName;

	public String getDateBaseName() {
		return dateBaseName;
	}

	public void setDateBaseName(String dateBaseName) {
		this.dateBaseName = dateBaseName;
	}

	public String getShardColumnName() {
		return shardColumnName;
	}

	public void setShardColumnName(String shardColumnName) {
		this.shardColumnName = shardColumnName;
	}
	
	

}
