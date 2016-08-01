package com.sxx.aop.ann;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sxx.aop.ann.around.bean.Performer;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:AopAroundApplicationContext.xml")
public class AopAnnAround {
	@Autowired
	ApplicationContext context;

	  @Test
	  public void audienceShouldApplaud() throws Exception {
	    Performer eddie = (Performer) context.getBean("eddie");
	    eddie.perform();
	  }
}

