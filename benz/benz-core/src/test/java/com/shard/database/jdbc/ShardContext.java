package com.shard.database.jdbc;

public class ShardContext {
	
	private String dataSourceId;
	
	private String replaceTable;
	
	private String originTable;

	public String getDataSourceId() {
		return dataSourceId;
	}

	public void setDataSourceId(String dataSourceId) {
		this.dataSourceId = dataSourceId;
	}

	public String getReplaceTable() {
		return replaceTable;
	}

	public void setReplaceTable(String replaceTable) {
		this.replaceTable = replaceTable;
	}

	public String getOriginTable() {
		return originTable;
	}

	public void setOriginTable(String originTable) {
		this.originTable = originTable;
	}
	
	

}
