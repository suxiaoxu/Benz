package com.sxx.common.pool;

import org.apache.commons.pool.KeyedObjectPool;
import org.apache.commons.pool.KeyedObjectPoolFactory;
import org.apache.commons.pool.KeyedPoolableObjectFactory;
import org.apache.commons.pool.impl.StackKeyedObjectPoolFactory;

public class KeyedObjectPoolSample {  
	  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
  
        Object obj = null;  
        KeyedPoolableObjectFactory factory = new KeyedPoolableObjectFactorySample();  
  
        KeyedObjectPoolFactory poolFactory = new StackKeyedObjectPoolFactory(  
                factory);  
  
        KeyedObjectPool pool = poolFactory.createPool();  
  
        String key = null;  
  
        try {  
  
           /* key = "java.lang.String";  
  
            obj = pool.borrowObject(key);  
            obj = "obj1";  
            // pool.returnObject(key, obj);  
            obj = pool.borrowObject(key);  
            pool.returnObject(key, obj);  
            obj = pool.borrowObject(key);  
            System.out.println(obj);  */
  
            System.out.println("============看另一个对象Person=============");  
  
            key = "key.Person";  
  
            Person person1 = (Person) pool.borrowObject(key);  
              
            person1.setId("1");  
            person1.setName("素还真");  
            System.out.println(person1);  
            pool.returnObject(key, person1);  
            System.out.println(person1);  
  
            Person person2 = (Person) pool.borrowObject(key);  
            person2.setId("2");  
            person2.setName("青阳子");  
            pool.returnObject(key, person2);  
            System.out.println(person2);  
            Person person3 = (Person) pool.borrowObject(key);  
            person3.setId("3");  
            person3.setName("一页书");  
            pool.returnObject(key, person3); 
            System.out.println(person3);  
            Person person4 = (Person) pool.borrowObject(key);  
            person4.setId("4");  
            person4.setName("业途灵");  
            pool.returnObject(key, person4); 
            System.out.println(person4);  
            System.out.println(person1);  
            System.out.println(person2);  
            System.out.println(person3);  
            System.out.println(person4);  
              
            pool.returnObject(key, person3);  
            Person person5 = (Person) pool.borrowObject(key);  
            System.out.println(person5);  
              
  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                pool.close();  
                System.out.println(pool);  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
  
    }  
  
}  
