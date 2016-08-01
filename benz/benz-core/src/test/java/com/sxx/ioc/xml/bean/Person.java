package com.sxx.ioc.xml.bean;

import org.springframework.stereotype.Service;

import com.sxx.ioc.xml.bean.MyClassAnnotation;

@MyClassAnnotation(uri ="asdf",desc="asdf")
@Service
public class Person {
	private int age;
	private String name;
	private int heghit;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHeghit() {
		return heghit;
	}
	public void setHeghit(int heghit) {
		this.heghit = heghit;
	}
	
	public int sub(int a,int b){
		return a+b;
	}

}
