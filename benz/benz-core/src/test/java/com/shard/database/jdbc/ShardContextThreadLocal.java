package com.shard.database.jdbc;

public class ShardContextThreadLocal {

	public static ThreadLocal<ShardContext> dataSourceKeyValue = new ThreadLocal<ShardContext>() {
		public ShardContext initialValue() {
			return null;
		}
	};
	
	public static void setShardRuleContext(ShardContext shardContext){
		dataSourceKeyValue.set(shardContext);
	}
}
