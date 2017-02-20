package com.shard.jdbc;

public class ShardInfoRuleImpl implements ShardInfoRule {

	private String databaseName = "shard";
	private String tableName = "shard_table0";
	@Override
	public String obtainDataBaseName(ShardInfoValue<?> shardInfoValue) {
		Long value = (Long)shardInfoValue.getColumnValue();
		long dataBaseNum = (value % 2) + 1;
		String dataBaseName = databaseName + dataBaseNum;
		return dataBaseName;
	}

	@Override
	public String obtainTableName(ShardInfoValue<?> shardInfoValue) {
		Long value = (Long)shardInfoValue.getColumnValue();
		long tableNum = (value % 4) +1;
		String tableNameT = tableName + tableNum;
		return tableNameT;
	}

}
