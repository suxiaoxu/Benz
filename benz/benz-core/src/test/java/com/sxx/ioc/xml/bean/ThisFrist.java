package com.sxx.ioc.xml.bean;

import com.sxx.ioc.ann.bean.MyClassAnnotation;

@MyClassAnnotation(uri ="asdf",desc="asdf")
public class ThisFrist {
	
	private String teacher;
	
	private String mather;

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getMather() {
		return mather;
	}

	public void setMather(String mather) {
		this.mather = mather;
	}
	
	public int sub(int a,int b){
		return a+b;
	}
	
	
}
