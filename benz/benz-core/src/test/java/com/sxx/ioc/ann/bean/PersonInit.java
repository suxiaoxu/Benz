package com.sxx.ioc.ann.bean;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Component
public class PersonInit {
	
	public void start(){
		System.out.println("start");
	}
	
	public void end(){
		System.out.println("end");
	}

}
