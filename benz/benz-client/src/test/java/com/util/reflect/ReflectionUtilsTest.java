package com.util.reflect;

import java.io.IOException;

import com.util.reflect.ReflectionUtils.ClassPathResource;

public class ReflectionUtilsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class<?>[]  sn = ReflectionUtils.getClasses("com.util", null);
			System.out.println(sn.getClass());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
