package com.sxx.common.pool;

import org.apache.commons.pool.BaseKeyedPoolableObjectFactory;

public class KeyedPoolableObjectFactorySample extends
		BaseKeyedPoolableObjectFactory {

	/**
	 * 创建对象方法
	 */
	@SuppressWarnings("unchecked")
	public Object makeObject(Object clsName) throws Exception {

		if (clsName == null || !(clsName instanceof String)
				|| "".equals(clsName)) {
			throw new RuntimeException("类名为空！");
		}

		System.out.println("创建一个新的对象:" + clsName);

		Person p1 = new Person();
		return p1;
	}

	@Override
	public void activateObject(Object key, Object obj) throws Exception {
		// TODO Auto-generated method stub
		super.activateObject(key, obj);
		System.out.println("激活对象");
	}

	@Override
	public void destroyObject(Object key, Object obj) throws Exception {
		// TODO Auto-generated method stub
		super.destroyObject(key, obj);
		System.out.println("销毁对象");
	}

	@Override
	public void passivateObject(Object key, Object obj) throws Exception {
		// TODO Auto-generated method stub
		super.passivateObject(key, obj);
		System.out.println("挂起对象");
	}

	@Override
	public boolean validateObject(Object key, Object obj) {
		// TODO Auto-generated method stub
		System.out.println("验证对象");
		return super.validateObject(key, obj);

	}

}
