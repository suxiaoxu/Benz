package com.sxx.aop.advice.bean;

public class Volunteer implements Thinker {
  private String thoughts;

  public void thinkOfSomething(String thoughts) {
	  System.out.println("start run .......");
    this.thoughts = thoughts;
  }

  public String getThoughts() {
    return thoughts;
  }
}