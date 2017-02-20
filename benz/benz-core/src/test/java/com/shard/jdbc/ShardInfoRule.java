package com.shard.jdbc;

public interface ShardInfoRule {
	
	/** 
	 * 通过分表字段值获取库名
	* @Title: obtainDataBaseName 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param t
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	public String obtainDataBaseName(ShardInfoValue<?> shardInfoValue);

	/** 
	 * 通过分表字段获取表名
	* @Title: obtainTableName 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param t
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	public String obtainTableName(ShardInfoValue<?> shardInfoValue);
}
