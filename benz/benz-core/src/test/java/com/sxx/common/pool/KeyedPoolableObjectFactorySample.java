package com.sxx.common.pool;

import org.apache.commons.pool.BaseKeyedPoolableObjectFactory;

public class KeyedPoolableObjectFactorySample extends
		BaseKeyedPoolableObjectFactory {

	/**
	 * �������󷽷�
	 */
	@SuppressWarnings("unchecked")
	public Object makeObject(Object clsName) throws Exception {

		if (clsName == null || !(clsName instanceof String)
				|| "".equals(clsName)) {
			throw new RuntimeException("����Ϊ�գ�");
		}

		System.out.println("����һ���µĶ���:" + clsName);

		Person p1 = new Person();
		return p1;
	}

	@Override
	public void activateObject(Object key, Object obj) throws Exception {
		// TODO Auto-generated method stub
		super.activateObject(key, obj);
		System.out.println("�������");
	}

	@Override
	public void destroyObject(Object key, Object obj) throws Exception {
		// TODO Auto-generated method stub
		super.destroyObject(key, obj);
		System.out.println("���ٶ���");
	}

	@Override
	public void passivateObject(Object key, Object obj) throws Exception {
		// TODO Auto-generated method stub
		super.passivateObject(key, obj);
		System.out.println("�������");
	}

	@Override
	public boolean validateObject(Object key, Object obj) {
		// TODO Auto-generated method stub
		System.out.println("��֤����");
		return super.validateObject(key, obj);

	}

}
