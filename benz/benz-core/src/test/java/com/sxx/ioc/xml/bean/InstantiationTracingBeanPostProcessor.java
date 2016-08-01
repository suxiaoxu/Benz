package com.sxx.ioc.xml.bean;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class InstantiationTracingBeanPostProcessor implements ApplicationListener<ContextRefreshedEvent>{

	private ThisFrist thisFrist;
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		System.out.println("on application run");
		System.out.println(thisFrist.sub(4, 5));
		System.out.println("=====");
		
	}
	public void setThisFrist(ThisFrist thisFrist) {
		this.thisFrist = thisFrist;
	}
	
	

}
