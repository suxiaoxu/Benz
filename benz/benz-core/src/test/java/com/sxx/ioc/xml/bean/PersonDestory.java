package com.sxx.ioc.xml.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class PersonDestory implements InitializingBean,DisposableBean{

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("start--destory");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("end--destory");
	}

}
