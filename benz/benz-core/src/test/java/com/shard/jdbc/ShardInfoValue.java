package com.shard.jdbc;

public class ShardInfoValue<T> {
	
	private String tableName;
	
	private String columnName;
	
	private T columnValue;

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public T getColumnValue() {
		return columnValue;
	}

	public void setColumnValue(T columnValue) {
		this.columnValue = columnValue;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	

}
