package com.shard.jdbc;

public interface ShardInfoRule {
	
	/** 
	 * ͨ���ֱ��ֶ�ֵ��ȡ����
	* @Title: obtainDataBaseName 
	* @Description: TODO(������һ�仰�����������������) 
	* @param @param t
	* @param @return    �趨�ļ� 
	* @return String    �������� 
	* @throws 
	*/
	public String obtainDataBaseName(ShardInfoValue<?> shardInfoValue);

	/** 
	 * ͨ���ֱ��ֶλ�ȡ����
	* @Title: obtainTableName 
	* @Description: TODO(������һ�仰�����������������) 
	* @param @param t
	* @param @return    �趨�ļ� 
	* @return String    �������� 
	* @throws 
	*/
	public String obtainTableName(ShardInfoValue<?> shardInfoValue);
}
