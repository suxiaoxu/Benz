package com.util.reflect;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class ReflectionURLTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		try {
			Enumeration<URL> resources = classLoader.getResources("com.util");
			
			for(Enumeration e=resources;e.hasMoreElements();){
				String thisName=e.nextElement().toString();
			    System.out.println(thisName+"--------------");
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
