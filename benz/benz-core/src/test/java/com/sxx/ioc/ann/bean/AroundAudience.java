package com.sxx.ioc.ann.bean;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAudience {
  //<start id="audience_around_bean"/> 
  public Object watchPerformance(ProceedingJoinPoint joinpoint) {
	  Object object = null;
	  try {
      System.out.println("The audience is taking their seats.");
      System.out.println("The audience is turning off their cellphones");
      long start = System.currentTimeMillis(); //<co id="co_beforeProceed"/>

      object = joinpoint.proceed(); //<co id="co_proceed"/>
      
      long end = System.currentTimeMillis(); // <co id="co_afterProceed"/>
      System.out.println("CLAP CLAP CLAP CLAP CLAP");
      System.out.println("The performance took " + (end - start)
          + " milliseconds.");
    } catch (Throwable t) {
      System.out.println("Boo! We want our money back!"); //<co id="co_afterException"/>
    }
    return object;
  }
  //<end id="audience_around_bean"/>
}
