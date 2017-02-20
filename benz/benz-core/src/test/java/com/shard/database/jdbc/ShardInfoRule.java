package com.shard.database.jdbc;

public interface ShardInfoRule<T> {
	
	ShardContext getShardeRule(T t);

}
