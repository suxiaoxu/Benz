package com.guava.cache;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

public class GuavaCache {

	//使用classLorderCache
	//采用单线程来对内存缓存进行管理，队列里面存放时间戳，当有新的访问时，对来的缓存进行失效操作
	@Test
	public void testClassLorderCache() throws ExecutionException{
		
		final String Hello = "hello";
		LoadingCache<String,String> cahceBuilder=CacheBuilder
		        .newBuilder()
		        .expireAfterWrite(3, TimeUnit.SECONDS)
		        .removalListener(new RemovalListener<String,String>(){
					@Override
					public void onRemoval(RemovalNotification<String,String> notification) {
						System.out.println("key = " + notification.getKey() +" value = " + notification.getValue());
					}
		        })
		        .build(new CacheLoader<String, String>(){
		            @Override
		            public String load(String key) throws Exception {
		            	System.out.println("start computer");
		            	sleep();//模拟计算过程
		                String strProValue= Hello + key+"!";  
		                System.out.println("end computer");
		                return strProValue;
		            }
		        }); 
		System.out.println(cahceBuilder.get("1"));
		System.out.println(cahceBuilder.get("2"));
		sleep();
		//System.out.println(cahceBuilder.get("1"));
		sleep();
		//System.out.println(cahceBuilder.get("2"));
		sleep();
		System.out.println(cahceBuilder.get("2"));
	}
	
	//第二种方式通过实现接口，来实现
	@Test
    public void testcallableCache()throws Exception{
        Cache<String, String> cache = CacheBuilder.newBuilder().maximumSize(1000).build();  
        String resultVal = cache.get("jerry", new Callable<String>() {  
            public String call() {  
                String strProValue="hello "+"jerry"+"!";                
                return strProValue;
            }  
        });  
        System.out.println("jerry value : " + resultVal);
        resultVal = cache.get("peida", new Callable<String>() {  
            public String call() {  
                String strProValue="hello "+"peida"+"!";                
                return strProValue;
            }  
        });  
        System.out.println("peida value : " + resultVal);  
    }
	
	private void sleep(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
