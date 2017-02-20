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

	//ʹ��classLorderCache
	//���õ��߳������ڴ滺����й�������������ʱ����������µķ���ʱ�������Ļ������ʧЧ����
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
		            	sleep();//ģ��������
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
	
	//�ڶ��ַ�ʽͨ��ʵ�ֽӿڣ���ʵ��
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
