package com.sxx.common.pool;

import java.util.NoSuchElementException;

import org.apache.commons.pool.BasePoolableObjectFactory;
import org.apache.commons.pool.ObjectPool;
import org.apache.commons.pool.ObjectPoolFactory;
import org.apache.commons.pool.PoolableObjectFactory;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.apache.commons.pool.impl.GenericObjectPoolFactory;

class ObjectFactory extends BasePoolableObjectFactory{

	@Override
	public Object makeObject() throws Exception {
		return new Person();
	}
	
}

public class ObjectPoolTest {

	public static void main(String[] args) throws NoSuchElementException, IllegalStateException, Exception {
		PoolableObjectFactory objectFactory = new ObjectFactory();
		ObjectPoolFactory objectPoolFactory = new GenericObjectPoolFactory(objectFactory);
		ObjectPool objectPool = objectPoolFactory.createPool();
		
		Person person1 = (Person) objectPool.borrowObject();
		Person person2 = (Person) objectPool.borrowObject();
		Person person3 = (Person) objectPool.borrowObject();
		Person person4 = (Person) objectPool.borrowObject();
		Person person5 = (Person) objectPool.borrowObject();
		Person person6 = (Person) objectPool.borrowObject();
		Person person7 = (Person) objectPool.borrowObject();
		Person person8 = (Person) objectPool.borrowObject();

		objectPool.returnObject(person1);
		objectPool.returnObject(person2);
		objectPool.returnObject(person3);
		objectPool.returnObject(person4);
		objectPool.returnObject(person5);
		objectPool.returnObject(person6);
		objectPool.returnObject(person7);
		objectPool.returnObject(person8);
		Person person9 = (Person)objectPool.borrowObject();
		Person person10 = (Person)objectPool.borrowObject();
		Person person11 = (Person)objectPool.borrowObject();
		objectPool.close();
	}

}
